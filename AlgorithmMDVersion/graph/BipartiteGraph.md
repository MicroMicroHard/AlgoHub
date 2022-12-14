二分图

### Graph Term Explanation

|Graph Term|Explanation|
|:----|:----|
|匹配|在G的一个子图M中，M的边集{E}中的任意两条边都不依附于同一个顶点，则称M是一个匹配|
|极大匹配(Maximal Matching)|是指在当前已完成的匹配下,无法再通过增加未完成匹配的边的方式来增加匹配的边数|
|最大匹配(maximum matching)|是所有极大匹配当中边数最大的一个匹配。选择这样的边数最大的子集称为图的最大匹配问题|
|完备匹配|如果一个匹配中，图中的每个顶点都和图中某条边相关联，则称此匹配为完全匹配，也称作完备匹配|


### Attention
+ 完全匹配一定是极大匹配，但是极大匹配不一定是完全匹配
+ 求二分图匹配可以用最大流(Maximal Flow)或者匈牙利算法(Hungarian Algorithm)。

### Implementation


### Source Code
|Source Code|JavaVersion|goVersion|
|:----|:----|:----|
|二分图判定|[javaVersion]()|[goVersion]()|
|完全多部图判定|||
|二分图匹配-最大流|||
|二分图匹配-匈牙利算法|||

### Blog
+ [二分图的最大匹配、完美匹配和匈牙利算法](https://www.renfei.org/blog/bipartite-matching.html)
