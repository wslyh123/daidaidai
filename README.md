亵渎计算器

这有个1，有个2，这有3...算了算了，扭了扭了。


参数值含义：

type：1亵渎，2带带带

hp：生命值

spellPower：法强

immunity：免疫，daidaidai就是免疫

shield：圣盾

master：奴隶主

child：亡语，当前仅支持亡语是生儿子这种情况，且不可能支持948，女王这种随机的亡语。当前多亡语触发挤占格子情况时亡语生成顺序是从左向右的。（有待改正）

flag：是否清掉对方的场

测试
request:

POST /test HTTP/1.1
Host: 127.0.0.1:8082
Content-Type: application/json;charset=UTF-8
Cache-Control: no-cache

{"type": 1, "oneself": [ {"hp": 1, "spellPower": 0, "shield": false, "master":false, "child": [{"hp": 1, "spellPower": 0, "shield": false, "master":false, "child": null}]}, {"hp": 3, "spellPower": 0, "shield": false, "master":true, "child": null} ], "enemy": [ {"hp": 10, "spellPower": 0, "shield": false, "master":false, "child": null}, {"hp": 11, "spellPower": 0, "shield": false, "master":false, "child": null} ] }



response:

{"flag":true,"test":{"type":1,"oneself":[{"hp":1,"spellPower":0,"shield":false,"master":true,"child":null},{"hp":2,"spellPower":0,"shield":false,"master":true,"child":null},{"hp":3,"spellPower":0,"shield":false,"master":true,"child":null},{"hp":3,"spellPower":0,"shield":false,"master":true,"child":null}],"enemy":[]}}
