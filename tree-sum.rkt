#lang racket

(define tree-sum
  (lambda (exp)
    (match exp                         ; 对输入exp进行模式匹配
      [(? number? x) x] ;exp是一个数x吗？如果是，那么返回这个数x => number? 是对表达式类型判断`*?`, clj: num-type?, fn?, vector?, readfn?
      [`(,e1 ,e2)                      ; exp是一个含有两棵子树的中间节点吗？=> 模式匹配:含有多少个表达式项,就去哪里解决问题
       (let ([v1 (tree-sum e1)]        ; 递归调用tree-sum自己，对左子树e1求值 => 二叉树递归tree-sum, 解决单个表达式项
             [v2 (tree-sum e2)])       ; 递归调用tree-sum自己，对右子树e2求值
         (+ v1 v2))])))                ; 返回左右子树结果v1和v2的和

(tree-sum '(1 2))
;; => 3
(tree-sum '(1 (2 3)))
;; => 6
(tree-sum '((1 2) 3))
;; => 6
(tree-sum '((1 2) (3 4)))
;; => 10

