# JavaParsingAndRegex
## Project Description
This repository contains Java programs that perform parsing using a stack-based approach and demonstrate the usage of regular expressions. The programs read input, process it according to specified rules, and output the results. Detailed explanations of each program's functionality are provided.

## Files
- `Parsing.java`: Java program that performs parsing using a stack-based approach.
- `regex.java`: Java program that demonstrates the usage of regular expressions.
- `f.txt`: Sample input file for the parsing program.

## Java Program Descriptions

### `Parsing.java`
This Java program implements a stack-based parsing algorithm to evaluate expressions. The program reads an input string containing an expression, processes it using a stack, and outputs the steps taken during the parsing process. The parsing rules include operations like shift and reduce based on predefined grammar.

#### Key Features:
- Uses a stack to parse and evaluate expressions.
- Implements shift and reduce operations based on a predefined grammar.
- Outputs each step of the parsing process, including the state of the stack and the current input.

#### Example Input (f.txt)
id+id*id$
#### Example Output
0id5 +idid$ Reduce 6
0F3 +idid$ Reduce 4
0T2 +idid$ Reduce 2
0E1 +idid$ Shift 6
0E1+6 idid$ Shift 5
0E1+6id5 id$ Reduce 6
0E1+6F3 id$ Reduce 4
0E1+6T9 id$ Shift 7
0E1+6T97 id$ Shift 5
0E1+6T97id5 $ Reduce 6
0E1+6T97F10 $ Reduce 3
0E1+6T9 $ Reduce 1
0E1 $ Accept

### `regex.java`
This Java program demonstrates the usage of regular expressions to match and process strings. It reads input strings, applies regular expression patterns, and outputs the matching results. The program is designed to showcase different regular expression functionalities, including pattern matching, capturing groups, and replacing text.

#### Key Features:
- Demonstrates the usage of regular expressions in Java.
- Matches input strings against regular expression patterns.
- Outputs the results of pattern matching, including captured groups and replaced text.

