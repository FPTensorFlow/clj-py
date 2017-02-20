### 将clojure代码编译为python代码
#### 打开你的天赋 
* 解释器和编译器的数学模型是来源SICP: eval/apply递归 + lambda演算 = 解释器/编译器
* 参照[王垠的博客](http://www.yinwang.org/blog-cn/2012/08/01/interpreter),在解释自身(输入的clojure代码)的过程,同时将Python的目标语言的log打印出来,完成转换 (如clj->js,先解释输入的clojure自身,然后将clojure解释编辑转为js目标语言)
* 参照[cl-python](https://common-lisp.net/project/clpython/)
* 利用模式匹配完成最简单的lambda演算解释和四则运算解释,需要事先做好所有的表达式类型判断
* 利用递归,解释递归每一个树形的节点
* 环境变量的问题
* 根据自己的理解的思路来搜索代码的实现和思考如何实现: 错误的桥找出正确的方式是什么(机器学习用错误来评估改进学习)
* `lambda化`行动决定一切: 最重要的做了什么,而不是其他, 这个才是原力的根源,影响力,不断FP lambda归纳,而λ💥组合表达新概念,快速失败💥
* 多维度去分解复杂问题 为`简单的λ子`: 咏春功夫驱动编程 + 文学驱动编程 + 中线吃饱驱动编程 + 碎片时间分布式组合λ编程
* 放松自己,归于零,坚持多一秒就胜利了: 1分钟150个俯卧撑是强大的微分为零的能力, 同样一个复杂功能的成熟的库就像吉尼斯纪录一样非一日可突破的, 每个精彩库后面都是艰难的N个马拉松的坚持多一秒
* 用宏和Org来文学生活驱动编程: 用文学λ语句来打开原力, 我坚持下来45分钟10公里的秘密=> 强大微分归零 + 文学功夫小龙驱动
* 学Lisp其实是在学Lisp机，这个不矛盾 ， 而且 Lisp机 比 Unix 机先进太多 
* 学C其实是在学OS，这个不矛盾: Py入门的话, 你很难深入进去OS
* 结合了历史 的行程: 学习数学就要学习数学历史,才能知道谁是原力, 谁是被组合出来的
