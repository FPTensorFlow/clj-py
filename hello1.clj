;; 宏的本质也是数据分析==>代码分析
;; (fn [a,b] (+ a b)) => "lambda a,b : a + b"
;; 确定表达式类型,可以获取第一个元素来判断 ==> (nth (expression) 0)
;; 表达式的组成: 第一个元素的函数关键字, 参数, body ==> (fnkey [params] body)
;; 如果是list,就要打开重组,如果是symbol就停止
(def fnbody0 '(fn [a] a))
(def fnbody '(fn [a,b] (+ a b)))
(defn get-fn-body [fnbody] (nth (rest (rest fnbody)) 0))
(defn get-fn-body-type [fnbody] (type (nth (rest (rest fnbody)) 0)))

(type (nth (rest (rest fnbody)) 0)) ;;=> (+ a b) ;;=> clojure.lang.PersistentList
(type fnbody) ;;=> clojure.lang.PersistentList
(get-fn-body-type fnbody) ;;=> clojure.lang.PersistentList
(get-fn-body-type fnbody0) ;;=> clojure.lang.Symbol

;; lambda的body处理:
(cond
  (= (get-fn-body-type fnbody) clojure.lang.Symbol) (get-fn-body fnbody)
  (= (get-fn-body-type fnbody) clojure.lang.PersistentList) (str "进入表达式处理:" (get-fn-body fnbody))
  ) ;;=> "进入表达式处理:(+ a b)"

;;(= (get-fn-body fnbody) '(+ a b)) ;;=> true

;; 四则运算是前缀转中缀, 判断是否为四则运算的表达式==> first 关键子一定是+-/*
(def fnnum '(+ a b))
(type (first fnnum)) ;;=> clojure.lang.Symbol
(defn +? [fnnum] (= (first fnnum) '+)) ;; (+? fnnum) ;;=> true
(defn -? [fnnum] (= (first fnnum) '-))
(defn *? [fnnum] (= (first fnnum) '*))
;;(defn /? [fnnum] (= (first fnnum) '/)) ;; / 是不允许的key
(cond
  (+? fnnum) (str (nth fnnum 1) " " (nth fnnum 0) " " (nth fnnum 2))
  ) ;; => "a + b"
