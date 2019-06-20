亵渎计算器

这有个1，有个2，这有3...算了算了，扭了扭了。


参数值含义：

type：-1亵渎，0-6带带带放的位置

hp：生命值

spellPower：法强

shield：圣盾

master：奴隶主

child：亡语

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