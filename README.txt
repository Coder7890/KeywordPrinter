To see results:

For Windows users, 

1. Download the zip file
2. Extract the zip file (should contain jar and config.properties file)
3. Create two folders in your workspace. One for "input", which have list of text files. Similarly, for "output".
4. Open config.properties file
5. Provide your local folder path for "input" and "output" folders.
   For reference, see the sample paths provided in the config.properties file.
6. Open command prompt.
7. cd to your extracted zip folder.
8. Type command -> java -jar keyword.jar
9. To check results, go to "output" folder created locally. Will should corresponding output .txt file
   For example: If the input text file in input folder is named as "test1.txt", then output resulted file will be shown as "test1_output.txt" in output folder.

For linux users,
The steps are same except such that, in step 8, instead of running command, just type command ./run.sh
(Note: I didn't executed results on linux machine, but guessing shell script would run succesfully)

Sample text files:

input file: test1.txt

# The first test file
red color
apple red roundish fruit # Apples are tasty
onion yellow roundish vegetable
long shape
shape .
banana yellow long fruit
yellow color
roundish shape
fruit food-type
food-type .
pear yellow roundish fruit
corn yellow long vegetable
color .
vegetable food-type

output file: test1_output.txt
shape food-type color red apple onion long banana yellow roundish fruit pear corn vegetable

