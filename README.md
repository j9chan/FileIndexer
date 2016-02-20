## Synopsis

Code challenge for RackSpace.

- Write logic that takes a blob of text as a parameter and tokenizes this blob
 into words. Words are delimited by any character other than a-z, A-Z, or 0-9.

- Write logic to track all unique words encountered and the number of times
 each was encountered. Words should be matched in a case-insensitive manner.
 This should return the top 10 words (and their counts).

- Provide some documentation for the code you wrote in each of the previous
 steps.

- You must test your code. Make sure you include some brief documentation on
 how to run the tests. Any collection of plain text files can be used as
 input, and we suggest you try out some free plain text books from
 http://www.gutenberg.org/

Note: See file-input branch for blobs containing filenames functionality (need to merge eventually)

## Code Example

### Tokenize and track words
- [src/main/java/com/codechallenge/Tokenizers/SpecialCharacterTokenizer.java](https://github.com/j9chan/FileIndexer/blob/master/src/main/java/com/codechallenge/Tokenizers/SpecialCharacterTokenizer.java)
```
HashMap<String, Integer> tokenizedStringCounter = new HashMap<String, Integer>();
String[] tokens = str.split("[^a-zA-Z0-9]");
for (String token : tokens) {
    if (!token.isEmpty()) {
        Integer searchResult = tokenizedStringCounter.get(token.toLowerCase());
        int updatedTokenCount = (searchResult == null) ? 1 : searchResult + 1;
        tokenizedStringCounter.put(token.toLowerCase(), updatedTokenCount);
    }
}
```
### Return top 10 words
- [src/main/java/com/codechallenge/FileIndexer.java](https://github.com/j9chan/FileIndexer/blob/master/src/main/java/com/codechallenge/FileIndexer.java)

```
Collections.sort(tokenizedStringCounterList, tokenComparator);
for(int i = 0; i < 10 && i < tokenizedStringCounterList.size(); i++) {
    System.out.println(String.format("%d %s",
            tokenizedStringCounterList.get(i).getValue(), tokenizedStringCounterList.get(i).getKey()));
}

```
## Installation

- Requires [Java 7+](https://www.java.com/en/download/)

```
git clone https://github.com/j9chan/FileIndexer.git
cd FileIndexer
```

## To run

```
./index.sh "blob of text"

```
Note: If the blob is too long you might get error: -bash: ./index.sh: Argument list too long

## Tests

### Run Unit Tests
- Install [Maven](https://maven.apache.org/)

```
mvn test
```
- The JUnit Tests are located at <path>/src/main/test/java/com/codechallenge
- Tests correspond to the tokenizer and indexer classes used in <path>/src/main/java/com/codechallenge

### Run functional tests
./tests/runSuite ./tests/testSuite.txt ./index.sh

- If it finishes silently, the tests have passed
- Solutions found partially by http://www.textfixer.com/tools/online-word-counter.php#newText2 and inspection

## Some Extra Bits

### General Approach and Why It Was Chosen:
- Used a hash map to store entries
- Used spilt() to tokenize - Can be optimized
- Sort entries according to most frequently seen - Can be optimized
- Print top 10 entries
- Assuming words are repetitive then this may work better than NlogN, N is the number of words to be processed

### Alternate Approaches and Why They Weren’t Chosen:
- Use a Priority Queue instead of sorting
    * Java builtin PriorityQueue uses O(NlogN) for enqueuing and dequeuing so would need to create a custom class
    * Create a max heap with O(N) heapify function where k=number of times seen and v=word
    * Worst Case is O(N) time
    * This wasn’t implemented due to time constraints. No built in Java structure for heaps, so heapify, bubble-down, and delete max, and testing would need to be implemented from scratch.
- Use Bash to append files together then process (fast way)
    * Not sure how extensible that would be + debugging
- Use built-in StringTokenizer instead of split

### Resource Needs and Performance:
- Resources: Java
- Performance: O(NlogN)
- Space Requirements: O(N) memory

### Assumptions Made About Dataset:
- Number of unique entries are not going to overflow memory
- Files are not going to overflow memory
- Text are words, English is repetitive so sorting may be faster if there aren't N unique entries

### Improvements:
* Handle Memory Overflows
    * Files are too large to fit into memory
    * Read line by line by buffering BufferedReader and a Scanner
    * Lots of unique entries so the HashMap is too large
    * Consider using temp files to store a hash table. Writing to disk is slow though.
    * Consideration: If you have a lot of nodes where you can split memory resources then might not be as much of a problem

* Testing
    * The way running tests could be improved so that unit tests and functional tests can be run together
    * runSuite script probably shouldn’t include the input since it can be large
    * Find a way to incorporate unit test strings into the functional tests since strings could be reused
    * Read from file for jUnit is not recommended

* General Improvements
    * Text specialization: Use dictionary to check if it is a word
    * Language variations: colour vs. color
    * More Java built-ins: Use StringTokenizer instead
    * Use wrappers to hide implementation
    * Logging?
    * Use command line arguments to control the number of words to return

* Test in non-Unix environments