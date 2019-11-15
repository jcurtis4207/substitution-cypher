# substitution-cypher
This program is used to encode/decode a message using a substitution cypher

It was written in Java for an extra credit project in a second semester Java class.
There were specific concepts we had to use, such as GUI, inheritance, etc.
This was my first time using implementing GUI in java, and my first experience with encryption methodologies.
It is pretty simple, but probably more complicated than it needs to be due to the stipulations of the assignment.
Here is the basic breakdown:

The Encode and Decode classes are used to create GUI frames.
The EncodePanel and DecodePanel classes create the GUI elements and define their interactions with the encryption code.
The Cipher class is used to create basic substitution cipher objects, with methods for encryption and decryption.
The RandomCipher class extends the Cipher class to add functionality for creating a random substitution cypher.

One caveat is that the encryption only works for lowercase letters and spaces.
It will simply convert any other character into a space.
