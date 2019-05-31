# Bitmap-Transformer

Building a bitmap (.bmp) transformer CLI. It will read a bitmap in from disk, run one or more color or raster 
transforms and then write it out to a new file. 

***Example Strategy***
1. Gather user input (infile, outfile, and transform)
2. Read the input bitmap file using the fs module
3. Parse the bitmap’s buffer into object representing a bitmap (using a constructor)
4. Using metadata from the parsed bitmap object run a transform on the buffer directly (mutate the color or raster data)
4. Write the mutated buffer to the output file path

## Author

Liz Mahoney
John Winters

## Version 

1.0.0

## Getting Started
1. In the terminal, create a folder in your local drive by running`mkdir bitmap-transformer`, then cd into that 
directory.
2. Clone this repo `git clone https://github.com/emd5/bitmap-transformer.git`.
3. Open with IntelliJ: `idea .`, make sure JDK is installed.
4. To run application: `./gradlew run --args 'input output transform'`




