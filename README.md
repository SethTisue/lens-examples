## What is it?

Example code for “Lenses: Fields as Values”, my intro talk on functional lenses in Scala. Includes code for hand-rolled lenses as well as automatically generated ones using [Shapeless](https://github.com/milessabin/shapeless/) and [Rillit](https://github.com/travisbrown/rillit).

## It's 2015 now. Is this still current?

No.

I think the talk is still a good introduction to lenses, and I wouldn't change anything about the standalone lens code, but the library details are now obsolete. Shapeless has changed a lot, Rillit seems abandoned, and lots of competition has sprung up such as [Quicklens](https://github.com/adamw/quicklens).

## When & where was the talk given?

 * June 2013 at Scala Days ([details](http://scaladays.org/#/june-11/room2/16:30-17:15/Lenses%3A-Fields-as-Values))
 * January 2013 for Chicago-Area Scala Enthusiasts ([details](http://www.meetup.com/chicagoscala/events/95809062/))
 * November 2012 for Boston Scala Enthusiasts ([details](http://www.meetup.com/boston-scala/events/90994702/))
 * July 2012 at Scalathon in Philadelphia

Unlike earlier versions, the June 2013 version includes coverage of the lens generator Rillit.

## How to run

```text
% git clone https://github.com/SethTisue/lens-examples
% cd lens-examples
% ./sbt
> test
...
> console
...
```

## Slides

[Google docs link](https://docs.google.com/presentation/d/1zW1Gm2M_x_cn9pGp6LQDwHDXQ4WSa4JTBQe1ADBtKjw/edit?usp=sharing) (June 2013 version)

## Video

[June 2013 version](http://www.parleys.com/play/51c387cae4b0ed8770356869) (June 2013 version; 45 minutes; audio and slides only, no video of me)

[November 2012 version](https://www.youtube.com/watch?v=BiHH3LzKV04) (November 2012 version; 65 minutes)

## License

![public domain](http://i.creativecommons.org/p/zero/1.0/88x31.png)

http://creativecommons.org/publicdomain/zero/1.0/

To the extent possible under law, Seth Tisue has waived all copyright and related or neighboring rights to the contents of https://github.com/SethTisue/lens-examples/. This work is published from the United States of America.
