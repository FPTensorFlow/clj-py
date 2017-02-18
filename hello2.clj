(require '[clojure.core.match :refer [match]])
;;每打开一次都要判断它是什么类型的表达式, 如果是fn那就转换为lambda,如果是四则运算那么就前缀转中缀
(defn +? [fnnum] (= (first fnnum) '+)) ;; (+? fnnum) ;;=> true
(defn -? [fnnum] (= (first fnnum) '-))
(defn *? [fnnum] (= (first fnnum) '*))
;; 除了fn?之外`(fn? #()) => true`, 其他都不能阻止执行
(defn num-type? [fnnum] (or (+? fnnum) (-? fnnum) (*? fnnum))) ;;(num-type? '(* 1 2)) ;;=> true
;; (fn? #()) => true
(defn readfn? [fnbody] (= (first fnbody))) ;; (readfn? '(fn [a] a)) => true
;; (defn get-expr-type [form] )
(defn get-fn-body [fnbody] (nth (rest (rest fnbody)) 0))
(defn get-fn-body-type [fnbody] (type (nth (rest (rest fnbody)) 0)))
;; 转换规则:
(defn mun-tra [fnnum] (num-type? fnnum) (str (nth fnnum 1) " " (nth fnnum 0) " " (nth fnnum 2)))
(defn fn-tra [fnbody]
  (if (and (= (first fnbody) 'fn) (vector? (nth fnbody 1)))
    (nth (rest (rest fnbody)) 0) )) ;; 如果这里是多表达式的化,会触发递归去再次解释
;; 递归的问题===> match, 交给模式匹配
;;(type (+ 1 2)) ;;=> java.lang.Long
;;(type (fn [x] x)) ;;=> fn

;;(defmacro aaa [form]
;;  `(type ~form))
;;(aaa (fn [x] x)) ;;=> user$eval1620$fn__1621
;;;; (type (fn [x] x)) ;;user$eval1624$fn__1625
;;
;;(defmacro bbb [form]
;;  ;;`(= (first '~form) 'fn)) ;;=> false
;;  ;;`(type (first '~form))) ;;=> clojure.lang.Symbol
;;  `(= (nth '~form 0) '~@fn))
;;(macroexpand-1
;; '(bbb (fn [x] x)))
;;;;=> false
;;
