# 用户登录编码实践

---

## 一. 编写demo

#### 采用spring boot开发登录demo
- 用户信息预选手动写入本地mysql, 不开发注册功能
- 页面:登录页, 登录成功页, 登录失败页
- 后端代码要求按功能划分模块, 如:bean mapper service controller
- 登录时除ID password外还要求有图片验证码
- 用户只有在登录成功时才能访问登录成功页

> 图示:https://www.processon.com/view/link/5c74d0f7e4b0c4e2166190e0

#### 思考: 
2. 密码的存储与传输
3. 验证码的生成 验证 过期
3. 页面权限验证

## 二. 对接lenovoid
1. 了解SSO, token等概念
2. 对接lenovoid
