### 参照[cl-python](https://common-lisp.net/project/clpython/),用Clojure将clj代码编译为python代码
#### 实现的思路 
* 参照[王垠的博客](http://www.yinwang.org/blog-cn/2012/08/01/interpreter),在解释自身的过程,同时将Python的目标语言的log打印出来,完成转换 (如clj->js,先解释clojure,然后将clojure编辑转为js目标语言)
* 利用模式匹配完成最简单的lambda演算解释和四则运算解释,需要事先做好所有的表达式类型判断
* 利用递归,解释递归每一个树形的节点
* 环境变量的问题
