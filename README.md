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

## Code Example - Basic Logic for tokenization and count
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
## Installation

Requires [Java 7+](https://www.java.com/en/download/)
- The .jar file should be located in <path>/target

### To run

```
./index.sh "blob of text"

```
Note: If the blob is too long you might get error: -bash: ./index.sh: Argument list too long

## Tests

### Run Unit Tests
Install [Maven](https://maven.apache.org/)

```
mvn test
```
- The JUnit Tests are located at <path>/src/main/test/java/com/codechallenge
- Tests correspond to the tokenizer and indexer classes used in <path>/src/main/java/com/codechallenge

### Run functional tests
<path>/tests/