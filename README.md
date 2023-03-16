## 돕는 [사람] (Dobneun [Salam])  
  
Dobneun is a helper for NMS related protocols, providing features such as:  
- [Custom Biomes](#CUSTOM-BIOMES)
- [Packets (W.I.P)](#PACKETS-(W.I.P))
- [Reflection](#REFLECTION)  
  
Below you can find more information about how to use these sections.

### CUSTOM BIOMES  
Custom biomes are something that are regularly sought after, and with the help of Dobneun,
they are now easily achievable using `com.ankoki.dobneun.biomes.CustomBiome` and it's helper classes.  
You can support things such as:  
- Music
- Colours of grass, water, fog, foliage and sky.
- Ambient Particles with many to choose from.  
  
The possibilities are endless, and many more such as terrain/entity generation are to come.  
You can find an example JavaPlugin creating this [here](examples/BiomePlugin.java).  
  
There are some important things to note.  
- You **MUST** register all biomes before startup. I am currently unsure if it needs to be done before worlds load, however I would recommend doing so. The worlds will need to know the biomes exist before loading them.
- That's about it, actually.
- Refer to point 1.
  
### PACKETS (W.I.P)  
Packets have not been started yet, however more information will be found here.  
  
### REFLECTION  
Reflection is very easy to do with Dobneun, as we can cut out alot of the work for you.  
There's not much to explain, just take a nice read of the `com.ankoki.dobneun.reflection.Reflection` class, found [here](src/main/java/com/ankoki/dobneun/reflection/Reflection.java).  