# vueJS
## MVVM 模式
MVVM 是 **Model-View-ViewModel** 的简写，它本质是 MVC 的改进版，MVVM 就是将其中的 **View**
的**状态和行为抽象化**，让我们将 UI 和业务逻辑分开；

MVVM 模式和 MVC 模式一样，主要目的是**分类视图(View)和模型(Model)**

Vue.JS 是一个提供了 MVVM 风格的双向数据绑定的 JavaScript 库，专注于 View 层；它的核心是 MVVM 中的 VM，也就是
ViewModel；ViewModel 负责 View 和 Model，保证视图和数据的一致性，这种轻量级的架构让前端开发更加高效、便捷；


## Vue 概述
Vue.JS 是一个构建数据驱动的 Web 界面的渐进式框架，其目的是通过尽可能简单的 API 实现响应的数据绑定和组合的视图组件；

> 官方定义：Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。
>Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，
>当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动

### 快速 Hello World 输出
```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>快速入门</title>
        <!-- 导入 vue.js 核心包 -->
        <script src="../vuejs/vuejs-2.5.16.js"></script>
    </head>
<body>
    <div id="app">
        {{message}}
    </div>
    <script>
        new Vue({
            el:'#app',  // 表示当前 Vue 对象接管对应 id 的 div 区域，注意此次有逗号
            data: {
                message: 'hello world' // 注意不要以分号结尾
            }
        }); // 此处才用分号结尾
    </script>
</body>
</html>
```
#### 插值表达式
数据绑定最常用的形式是使用`Mustache`语法(双大括号)的文本插值，`Mustache`标签将会被替代为
对应数据对象上属性的值；无论何时，绑定的数据对象上属性发送了改变，插值处的内容都会更新

Vue.js 都提供了完全的 JavaScript 表达式的支持：

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <!-- 导入 vue.js 核心包 -->
        <script src="../vuejs/vuejs-2.5.16.js"></script>
    </head>
<body>
    <div id="app">
        {{message}}
        <!-- 一元运算表达式 -->
        {{ number + 1 }}
        <!-- 三元表达式 -->
        {{ ok ? "YES" : "NO" }}
        <!-- 不生效：这是语句，不是表达式 -->
        {{ var a = 1 }}
        <!-- 控制流程不生效，请使用三元运算符 -->
        {{ if (ok) { return message } }}
        
    </div>
</body>
</html>
```
    
这些表达式会在所属的 Vue 实例的数据作用域下作为 JavaScript 被解析

> 有个限制就是：每个绑定只能包含单个表达式，其中控制流程不会生效，只能使用三元表达式


## VueJS 常用的系统指令
### v-on
可以用`v-on`指令监听 DOM 事件，并在触发时运行一些 JavaScript 代码

#### v-on:click
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>v-on:click</title>
    <script src="../vuejs/vuejs-2.5.16.js"></script>
</head>
<body>
    <div id="app">
        {{ message }}
        <button v-on:click = "fun1('good')"> 点击改变 </button>
    </div>
    <script>
        new Vue ({
           el: '#app',
           data: {
               message: 'hello world'
           },
           methods: {
               fun1: function (msg) {
                   this.message = msg;
               }
           }
        });
    </script>
</body>
</html>
```

#### v-on:keydown

```html

```

