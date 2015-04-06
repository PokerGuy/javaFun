<h1>Fun Little Java Code Sample</h1>

The goal is to create a Java program that takes an input and then converts the number to text. For example java hello 123
gives an output of One Hundred Twenty Three. Seems pretty simple and straight forward until you start coding...

First things first, I wanted to put some basic limits on this. The class is only going to accept integegers from -2,147,483,648 and 2,147,483,647.
Maybe that's arbitrary, but it seems like a reasonable limitation. Next, the class is going to do some basic sanity checks:
only one argument is allowed to be passed in and that argument can be cast to an integer.

Up next, check to see if the number is less than zero. If it is, no problem, we just start our output with the word "Negative "
(trailing space intended) and then multiply by -1 and move on our way. Next, if the input is 0, then it's a special case,
our output can simply be "Zero" and there's no need for further processing.

Basically, when we say numbers we are reading three digit chunks at a time and then appending a word after each "chunk". For example,
123,456,789 is read One Hundred Twenty Three Million (the million is the append) Four Hundred Fifty Six Thousand (thousand is the append)
Seven Hundred Eighty Nine. So, that's what our program is going to do. Unfortunately, we have no idea of the number of
digits that will be passed in and it would make it really easy if we knew we could always work with these three digit chunks.
No problem, we will look at the string length of the number and do a modulus operation and append some zeros to the beginning to
make sure that our string is now always divisible by three.

Now, we loop through the string from left to right processing each chunk and adding the append. The append portion can be determined
by the total number of loops necessary to process the string and the current loop. Usually, hard coding is bad, but since this
is a basic code sample, I'm going to let it slide. It would be cool if it was set up to be configurable and possibly do a lookup
to handle other languages, but that is beyond the scope of this exercise.