;; 先将Clojure转为Python更容易些,就像clj->js一样更容易实现
;; "(fn [a] a)" => "lambda a: a"
;; 1.获得表达式的类型
(defmacro get-type [form]
  `(type (first '~form)) )
(macroexpand-1 (get-type (fn [a] a))) ;;=> clojure.lang.Symbol
;; (= (first '(fn [a] a)) 'fn) ;;=> true
;; 2. 生成类型判断的基本函数
(defmacro init-type [] `(defun ~name ))
;; 3. 列表处理转换
(first '(fn [a] a)) ;;=> fn
(nth '(fn [a] a) 1) ;;=> [a]
(nth '(fn [a] a) 2) ;;=> a
(type (nth '(fn [a] a) 1)) ;;=> clojure.lang.PersistentVector
;;(defmacro pyfn [form]  )
;; 4. 从最简单的什么都没有的字符串拼接填充模板开始,到模式编辑转换
(def fnbody '(fn [a] a))
(str
 ;; 这里是关键字转换
 (if (= (first fnbody) 'fn)
   "lambda"
   )
 " "
 ;; 这里是参数
 (if (vector? (nth fnbody 1)) ;; 基本类型vector,symbol
   (str (first (nth fnbody 1)) ":") ;; : 是python高频的符号,def函数和for循环等都有
   )
 " "
 ;; 这里是body
 ;;(nth (rest (rest '(fn [a] (+ a 1)))) 0) ;; => (+ a 1) 
 (nth (rest (rest fnbody)) 0)
 ) ;; => "lambda a: a"
