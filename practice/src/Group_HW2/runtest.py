import json
import subprocess
import sys
import argparse
import os

class TestTool:
    # read in json file representing test case
    def loadTest(self, jsonfilename):
        jsonfile = open(jsonfilename)
        return json.load(jsonfile)

    # For "build" step that must be done before running the test cases
    def build(self, testcase):
        if 'build' in testcase.keys():
            compileResult = subprocess.run(testcase['build'])
            assert(compileResult.returncode == 0)

# For "build" step that must be done before running the test cases
def build(testcase):
    if 'build' in testcase.keys():
        compileResult = subprocess.run(testcase['build'], shell=True)
        assert(compileResult.returncode == 0)

# Comparing expected result to actual result of running the command
def check(expected, actual, skip):
    if expected == None:
        return actual == None
    success = True
    for line in expected:
        if bool(skip):
            ''' if true, ignore lines with a character/word '''
            tmp = actual.readline()
            while tmp.startswith('a'): tmp = actual.readline()
            if line != tmp:
                success = False
                break   
            tmp = actual.readline()
            while tmp.startswith('a'): tmp = actual.readline()
            line = tmp
            if line and not tmp.startswith('a'): 
                success = False
                return success  
        else:
            ''' if false, compare line by line '''
            res = actual.tell()
            tmp = line
            if line != actual.readline():
                success = False
            actual.seek(res)
            return success

# Running the test cases
def run(cmd, skip, one):
    failures = 0
    successes = 0
    for case in cmd['cases']:
        case_pass = True
        case_keys = case.keys()
        # print(case.keys())
        has_infile = 'in' in case_keys
        has_args = 'args' in case_keys
        has_expected = 'expected' in case_keys
        has_err = 'expected_err' in case_keys
        has_skip = 'skip' in case_keys # checking flag to skip certain test cases
        if has_skip and case['skip'] == "true":
            continue
        if 'expected_return_code' in case_keys:
            expected_return_code = case['expected_return_code']
        else: expected_return_code = 0
        if has_infile:
            infile = open(case['in'])
        if has_args:
            cmd_text = cmd['cmd'] + ' ' + case['args']
        else: cmd_text = cmd['cmd']
        if has_expected:
            outname = case['name'] + '__actual.txt'
            actual = open(outname, 'w')
            expected = open(case['expected'])
        else:
            actual = None
            expected = None
        if has_err:
            errname = '__actual_err.txt'
            actual_err = open(errname, 'w')
            expected_err = open(case['expected_err'])
        else:
            actual_err = None
            expected_err = None
        if not has_infile:
            runResult = subprocess.run(cmd_text,text=True,stdout=actual,stderr=actual_err)
        else: runResult = subprocess.run(cmd_text,text=True,stdin=infile,stdout=actual,stderr=actual_err)
        if runResult.returncode != expected_return_code:
            print("Case " + case['name'] + " expected " + str(expected_return_code) + ", but actual returncode = " + str(runResult.returncode))
            case_pass = False
        if has_expected: actual = open(outname)
        if has_err: actual_err = open(errname)

        if check(expected, actual, skip) and check(expected_err, actual_err, skip):
            print("Case " + case['name'] + " passes")
        else:
            print("Case " + case['name'] + " fails because actual output did not match expected output")
            case_pass = False

            if case_pass:
                successes += 1
            else: failures += 1
            if has_infile: infile.close()
            if has_expected:
                actual.close()
                expected.close()
            if has_err:
                actual_err.close()
                expected_err.close()
        return (successes, failures)

usage = "python runtest.py testfile"

class EnhancedTestTool(TestTool):
    
    # Comparing expected result to actual (word by word)
    # this method can be overridden
    def check(self, expected, actual):
        if expected == None:
            return actual == None
        success = True
        for currentExpectedLine in expected:
            currentActualLine = actual.readline()
            i=0 # initialize index to read array holding spitted words from line
            for currentExpectedWord in currentExpectedLine.split():
                currentActualWord = currentActualLine.split()[i]
                i=i+1 # increment index to read next word in next iteration
            if currentExpectedWord != currentActualWord:
                success = False
                break
        line = actual.readline() # looking for extra line in actual file
        if line: # True if not at eof
            print('actual still has: ' + line)
            success = False
        return success

if __name__ == "__main__":
    skip = 0
    one = 0
    parser = argparse.ArgumentParser()
    parser.add_argument("-i", "--ignore", action ="store_true", help = "skip lines with #")
    parser.add_argument("-l", "--line", action ="store_true", help = "match one line")
    parser.add_argument('filename',action = 'store', type = str, help = "json file")
    args = parser.parse_args()

    if len(sys.argv) < 2:
        print(usage)
        exit(1)

    PATH = os.path.dirname(os.path.abspath(__file__))
    myFile = os.path.join(PATH, str(args.filename))
    if args.ignore: skip = 1
    if args.line: one = 1

    tool = TestTool()

    testcase = tool.loadTest(myFile)
    build(testcase)
    print(run(testcase, skip, one))

