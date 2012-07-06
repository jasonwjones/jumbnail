Jumbnail
========

An extremely simple library and command-line utility written in Java. Named so because it's Java, dumb, and for making thumbnails.

Ostensibly created because using Imagemagick/cron was not viable, nor is/was manipulating the images on the client side with Javascript/jQuery/whathaveyou.

The project is broken down into a simple library that does the resizing (using a very powerful Java resizing solution), and an additional/separate command-line tool that can take the names of two folders and a few options. The process is to scan the input folder for all images and then create the thumbnail with the given dimensions and output it with the same name but in the target folder. 

By default the app will not perform a resize operation if it finds a target file with the existing name (i.e., it makes the assumption that the image has already been resized. This makes the process faster and more amenable to running over and over even on a large set of files.

Licensed under Apache License Version 2.0.
