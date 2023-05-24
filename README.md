# mestint

# 8-as puzzle

A játék egy 3x3-as puzzle, amely 1 és 8 között tartalmaz számokat, az üres helyen pedig 0-t.
A játék elején a számok össze vannak keverve és a cél, hogy sorban
0 1 2
3 4 5
6 7 8
legyenek.

Csak a 0-t tudjuk mozgatni, úgy hogy a mellette lévővel cserélhetjük meg. 
Ha elmozgattuk a 0-t, tehát elvégeztünk egy műveletet, akkor a mozgatás előtti állapot zárt lesz.

A beadandóban fájlból olvasunk be egy kezdőállapotot.
Kezdőállapot:
3 1 2
4 7 5
6 0 8

Bármilyen 3x3-as kezdőállapotot megadhatunk.

Az állapottér a lehetséges lépésekkel 2 mélységben:
                             3 1 2
                             4 7 5
                             6 0 8
                      
            3 1 2                   3 1 2           3 1 2
            4 0 5                   4 7 5           4 7 5
            6 7 8                   0 6 8           6 8 0

3 1 2       3 0 2      3 1 2        3 1 2           3 1 2
0 4 5       4 1 5      4 5 0        0 7 5           4 7 0
6 7 8       6 7 8      6 7 8        4 6 8           6 8 5

A Luger-féle keretrendszer osztályait és metódusait használva megadhatóak a lehetséges lépések és a megoldás.
