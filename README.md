### 参照[cl-python](https://common-lisp.net/project/clpython/),用Clojure将clj代码编译为python代码
#### 实现的思路 
* 参照[王垠的博客](http://www.yinwang.org/blog-cn/2012/08/01/interpreter),在解释自身(输入的clojure代码)的过程,同时将Python的目标语言的log打印出来,完成转换 (如clj->js,先解释输入的clojure自身,然后将clojure解释编辑转为js目标语言)
* 利用模式匹配完成最简单的lambda演算解释和四则运算解释,需要事先做好所有的表达式类型判断
* 利用递归,解释递归每一个树形的节点
* 环境变量的问题
* 解释器和编译器的数学模型是来源SICP: eval/apply + lambda演算 = 解释器/编译器
