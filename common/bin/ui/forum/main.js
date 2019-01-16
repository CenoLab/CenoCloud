(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var routes = [
    { path: '', redirectTo: 'forum', pathMatch: 'full' },
    { path: 'forum', redirectTo: 'forum/index', pathMatch: 'full' },
    { path: '**', redirectTo: 'forum', pathMatch: 'full' },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "@media (min-width: 1500px){\r\n    .container {\r\n        width: 1466px;\r\n    }\r\n}\r\n\r\n/* .forum-left{\r\n    background-color:red;\r\n}\r\n\r\n.forum-right{\r\n    background-color:blue;\r\n} */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-forum-nav></app-forum-nav>\n<div class=\"container\">\n\t<div class=\"row\">\n\t\t<router-outlet></router-outlet>\n\t</div>\n</div>\n\n<app-forum-footer class=\"forum-footer\"></app-forum-footer>\n\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent.prototype.ngOnInit = function () {
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _forum_forum_nav_forum_nav_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./forum/forum-nav/forum-nav.component */ "./src/app/forum/forum-nav/forum-nav.component.ts");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _service_api_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./service/api.service */ "./src/app/service/api.service.ts");
/* harmony import */ var _forum_forum_footer_forum_footer_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./forum/forum-footer/forum-footer.component */ "./src/app/forum/forum-footer/forum-footer.component.ts");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _forum_forum_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./forum/forum.component */ "./src/app/forum/forum.component.ts");
/* harmony import */ var _forum_forum_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./forum/forum.module */ "./src/app/forum/forum.module.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
                _forum_forum_nav_forum_nav_component__WEBPACK_IMPORTED_MODULE_3__["ForumNavComponent"],
                _forum_forum_footer_forum_footer_component__WEBPACK_IMPORTED_MODULE_6__["ForumFooterComponent"],
                _forum_forum_component__WEBPACK_IMPORTED_MODULE_8__["ForumComponent"],
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_4__["HttpModule"],
                _forum_forum_module__WEBPACK_IMPORTED_MODULE_9__["ForumModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_7__["AppRoutingModule"],
            ],
            providers: [
                _service_api_service__WEBPACK_IMPORTED_MODULE_5__["ApiService"]
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/forum/forum-article/forum-article.component.css":
/*!*****************************************************************!*\
  !*** ./src/app/forum/forum-article/forum-article.component.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".article-title{\r\n    line-height: 60px;\r\n    background-color: #fff;\r\n    padding: 0;\r\n}\r\n\r\n.article-title .active{\r\n    text-align: center;\r\n    color: #36f;\r\n    border-bottom: 1px solid #36f;\r\n}\r\n\r\n.article_container{\r\n    background-color: #fff;\r\n    margin-top: 5px;\r\n}\r\n\r\n.article-summary{\r\n    padding: 1em auto;\r\n    margin-top: 10px;\r\n}\r\n\r\n.article-summary p{\r\n    background: #f5f5f5;\r\n    padding:1em;\r\n    font-size: 0.9em;\r\n}\r\n\r\n.article-content p{\r\n    padding:1em;\r\n}\r\n\r\n.article-report{\r\n    margin: 10px auto;\r\n}\r\n\r\n.article-report>div{\r\n    padding: 0.5em;\r\n    background: #f8f8f8;\r\n    border: solid 1px #ede4e4;\r\n}\r\n\r\n.article-report>div>div{\r\n    background: #fff;\r\n    border: solid 1px #ede4e4;\r\n    padding: 0.5em;\r\n}\r\n\r\n.other-article li+li{\r\n    margin-top: 0.5em;\r\n}\r\n\r\n.article-author{\r\n    line-height: 50px;\r\n}\r\n\r\n.article-summary,.article-author,.article-content,.article-report{\r\n    margin:10px 0;\r\n}\r\n\r\n.form_group{\r\n    margin-top: 10px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.comment{\r\n    border-bottom: 1px solid #F0F0F0;\r\n    padding-top: 10px;\r\n    padding-bottom: 10px;\r\n}\r\n\r\n.comment img{\r\n    border-radius: 100%;\r\n    margin-left: 10px;\r\n    margin-right: 10px;\r\n    width: 60px;\r\n    float: left;\r\n}\r\n\r\n.comment .comment-content{\r\n    margin-left: 80px;\r\n    margin-top: 8px;\r\n    line-height: 170%;\r\n    word-wrap: break-word;\r\n}\r\n\r\n.comment .comment-content i{\r\n    white-space: nowrap;\r\n}\r\n\r\n.comment .comment-content .comment-nickname{\r\n    color:#2E6BB0;\r\n    padding-right: 6px;\r\n    font-style: normal;\r\n}\r\n\r\n.comment .comment-content .comment-time{\r\n    color: #999999;\r\n    cursor: pointer;\r\n}\r\n\r\n.comment .comment-content .comment-time:hover i{\r\n    color: #36f;\r\n}\r\n\r\n.comment .comment-content .comment-time i{\r\n    margin-left: 30px;\r\n    margin-top: 3px;\r\n    padding-right: 3px;\r\n}\r\n\r\n.comment .comment-content .comment-time i::before{\r\n    padding-right: 5px;\r\n}\r\n\r\n@media screen and (max-width:768px){\r\n    .comment img{\r\n        margin-left: 0px;\r\n    }\r\n\r\n    .comment .comment-content{\r\n        margin-left: 70px;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/forum/forum-article/forum-article.component.html":
/*!******************************************************************!*\
  !*** ./src/app/forum/forum-article/forum-article.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n\t<div [style.display]=\"load ? 'none' : 'block'\" class=\"col-sm-8 col-xs-12 height-load\">\n\t\t<i class=\"fa fa-spinner  fa-4x fa-pulse\"></i>\n\t</div>\n\t<div [style.display]=\"load ? 'block' : 'none'\" class=\"col-sm-8 col-xs-12\" *ngFor=\"let art of article\">\n\t\t<div class=\"row  article-title\">\n\t\t\t<div class=\"col-sm-3 active\">文章</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow article_container\" data-wow-delay=\"0.4s\">\n\t\t\t<h1 class=\"col-sm-12 col-xs-12 text-center\">{{art.article.title}}</h1>\n\t\t\t<div class=\"col-sm-12 col-xs-12 article-author\">\n\t\t\t\t<div class=\"col-sm-3 col-xs-6 text-center\">\n\t\t\t\t\t{{art.author.nickName}}\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-sm-3 col-xs-6 text-center\">\n\t\t\t\t\t收藏{{art.article.favCount}}\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-sm-3 col-xs-6 text-center\">\n\t\t\t\t\t{{art.article.modifyTime.split(\" \")[0]}}\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-sm-3 col-xs-6 text-center\">\n\t\t\t\t\t点赞数{{art.article.starCount}}\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"col-md-12 col-xs-12 article-summary\">\n\t\t\t\t<p>摘要： {{art.article.abstractContent}}</p>\n\t\t\t</div>\n\t\t\t<div class=\"col-md-12 col-xs-12 article-content\" [innerHTML]=\"art.article.content\">\n\t\t\t</div>\n\t\t\t<div class=\"col-md-12 col-xs-12 article-report\">\n\t\t\t\t<div>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t如果您发现本社区中有涉嫌抄袭的内容，欢迎发送邮件至：forum@support.cenocloud.com 进行举报，并提供相关证据，一经查实，本社区将立刻删除涉嫌侵权内容。\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div class=\"row p1 wow zoomIn article_container other-article\" data-wow-delay=\"0.4s\">\n\t\t\t<div class=\"col-sm-12\">\n\t\t\t\t<p style=\"border-bottom: solid 1px #f8f8f8;padding: 0.5em 0;\">相关文章</p>\n\t\t\t</div>\n\t\t\t<!-- <div class=\"col-sm-6 col-xs-12\">\n\t\t\t\t<ul>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t</ul>\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-6 col-xs-12\">\n\t\t\t\t<ul>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t\t<li>共生GBA全球区块链技术应用大会圆满落幕</li>\n\t\t\t\t</ul>\n\t\t\t</div> -->\n\t\t</div>\n\n\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t<div class=\"col-sm-12 col-xs-12 form_group\">\n\t\t\t\t<div class=\"editor\">\n\t\t\t\t\t<div class=\"editor-container\">\n\t\t\t\t\t\t<textarea name=\"comment\" rows=\"4\" class=\"form-control js-mention js-auto-expand editor-content\" id=\"comment\" placeholder=\"写下你的评论…\"\n\t\t\t\t\t\t required=\"\"></textarea>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-12 col-xs-12 form_group\">\n\t\t\t\t<input type=\"text\" placeholder=\"输入验证码内容\" />\n\t\t\t\t<img style=\"height:38px;\" src=\"https://api.sso.cenocloud.com/login/nasde/create\" />\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-3 col-xs-6 form_group\">\n\t\t\t\t<button (click)=\"addComment()\" type=\"submit\" class=\"comment_button\" style=\"width:100%;background: #36f;color:#fff;font-weight: bold;height: 3em;line-height: 3em;border:none;\">评论</button>\n\t\t\t</div>\n\t\t</div>\n\n\n\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t<p style=\"border-bottom: solid 1px #f8f8f8;padding: 0.5em;\">网友评论</p>\n\t\t\t<div class=\"col-sm-12 col-xs-12\" *ngFor=\"let comment of comments\">\n\t\t\t\t<div class=\"comment\">\n\t\t\t\t\t<img src=\"assets/img/logo.png\">\n\t\t\t\t\t<div class=\"comment-content\">\n\t\t\t\t\t\t<p>\n\t\t\t\t\t\t\t<i class=\"comment-nickname\">{{comment.author.nickName}}</i>:&nbsp;{{comment.comment.content}}\n\t\t\t\t\t\t</p>\n\t\t\t\t\t\t<p class=\"comment-time\">\n\t\t\t\t\t\t\t{{comment.comment.modifyTime.substring(0,19)}}\n\t\t\t\t\t\t\t<i class=\"fa fa-thumbs-o-up\" (click)=\"Star(comment.comment.id)\">{{comment.comment.starCount}}</i>\n\t\t\t\t\t\t</p>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\t<div class=\"col-sm-4 hidden-xs\">\n\t\t<div style=\"margin-left: 10px;\">\n\t\t\t<app-forum-right-function></app-forum-right-function>\n\t\t\t<div class=\"row\" style=\"margin-top:1em;\" *ngFor=\"let art of article\">\n\t\t\t\t<div class=\"col-md-12\" style=\"background: #fff;padding-bottom: 1em;\">\n\t\t\t\t\t<h3 class=\"col-md-12\" style=\"font-size:1em;border-bottom: solid 1px #f8f8f8;font-weight: lighter;padding-bottom:0.5em;font-size: 1.3em;\">达人介绍</h3>\n\t\t\t\t\t<div class=\"col-md-5\">\n\t\t\t\t\t\t<img class=\"col-md-12\" src=\"assets/img/logo.png\" />\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"col-md-7\">\n\t\t\t\t\t\t<p>{{art.author.nickName}}</p>\n\t\t\t\t\t\t<p>文章 {{art.author.articleCount}}篇 | 关注 {{art.author.followCount}}</p>\n\t\t\t\t\t\t<button class=\"comment_button\" style=\"width:6em;background: #fff;color:#36f;font-weight: bold;height: 2.5em;line-height: 2.5em;border:solid 1px #36f;\">关注</button>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"row\" style=\"margin-top:1em;\">\n\t\t\t\t<div class=\"col-md-12\" style=\"background: #fff;padding-bottom: 1em;\">\n\t\t\t\t\t<h3 class=\"col-md-12\" style=\"font-size:1em;border-bottom: solid 1px #f8f8f8;font-weight: lighter;padding-bottom:0.5em;font-size: 1.3em;\">博主其他文章</h3>\n\t\t\t\t\t<ul style=\"padding: 0;margin:0;padding-left: 1em;\">\n\t\t\t\t\t\t<li style=\"padding: 0;margin: 0;margin-top:1em;\">\n\t\t\t\t\t\t\t· 量子隐形传输\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li style=\"padding: 0;margin: 0;margin-top:1em;\">\n\n\t\t\t\t\t\t\t· 量子计算：第四次工业革命的引擎\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li style=\"padding: 0;margin: 0;margin-top:1em;\">\n\t\t\t\t\t\t\t· AI和量子计算的“联姻”开启新世界\n\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li style=\"padding: 0;margin: 0;margin-top:1em;\">\n\t\t\t\t\t\t\t· 量子计算又迈出了一大步\n\t\t\t\t\t\t</li>\n\t\t\t\t\t</ul>\n\t\t\t\t\t<p style=\"padding: 0;margin: 0;margin-top:1em;text-align:right;\">\n\t\t\t\t\t\t<a>更多</a>\n\t\t\t\t\t</p>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\n\t<app-modal-log #modal></app-modal-log>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-article/forum-article.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/forum/forum-article/forum-article.component.ts ***!
  \****************************************************************/
/*! exports provided: ForumArticleComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumArticleComponent", function() { return ForumArticleComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _service_forum_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../service/forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../modal-log/modal-log.component */ "./src/app/forum/modal-log/modal-log.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ForumArticleComponent = /** @class */ (function () {
    function ForumArticleComponent(forumservice, route) {
        this.forumservice = forumservice;
        this.route = route;
        this.article = [];
        this.load = false;
        this.article_id = Number(this.route.snapshot.params['id']);
        this.comments = [];
    }
    ForumArticleComponent.prototype.ngOnInit = function () {
        this.getForumArticle();
        //this.getComment();
    };
    ForumArticleComponent.prototype.getForumArticle = function () {
        var _this = this;
        this.forumservice.getForumArticle(this.article_id)
            .then(function (res) {
            if (res.state = true) {
                _this.article[0] = res.data;
                _this.comments = res.data.comments;
                _this.load = true;
                console.log(_this.article);
            }
            else {
                _this.modal.show(res.msg, "1500");
            }
        });
    };
    ForumArticleComponent.prototype.getComment = function () {
        var _this = this;
        var page = 0;
        var num = 10;
        this.forumservice.getComment(this.article_id, page, num)
            .then(function (res) {
            console.log(res.data);
            _this.comments.push(res.data);
        });
    };
    ForumArticleComponent.prototype.addComment = function () {
        var _this = this;
        if ($('textarea[name=comment]').val() == "") {
            this.modal.show("评论不能为空", "1500");
            return;
        }
        var data = {
            articleId: this.article_id,
            comment: $('textarea[name=comment]').val()
        };
        this.forumservice.publishComment(data).then(function (res) {
            $('textarea[name=comment]').val('');
            _this.modal.show("提问成功", "1500");
            _this.comments.unshift(res.data);
        });
    };
    ForumArticleComponent.prototype.Star = function (id) {
        this.modal.show("开发中...", "1500");
        // this.forumservice.Star(id).then(res => {
        // 	console.log(res);
        // }
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])("modal"),
        __metadata("design:type", _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_3__["ModalLogComponent"])
    ], ForumArticleComponent.prototype, "modal", void 0);
    ForumArticleComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-article',
            template: __webpack_require__(/*! ./forum-article.component.html */ "./src/app/forum/forum-article/forum-article.component.html"),
            styles: [__webpack_require__(/*! ./forum-article.component.css */ "./src/app/forum/forum-article/forum-article.component.css")]
        }),
        __metadata("design:paramtypes", [_service_forum_service__WEBPACK_IMPORTED_MODULE_2__["ForumService"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"]])
    ], ForumArticleComponent);
    return ForumArticleComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-footer/forum-footer.component.css":
/*!***************************************************************!*\
  !*** ./src/app/forum/forum-footer/forum-footer.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".footer{\r\n    padding:2em 0 0 1em;\r\n    margin-top:0em;\r\n    background:rgb(56,56,56);\r\n    color:#fff;\r\n}\r\n\r\n.footer .icon{\r\n    padding: 10px 0;\r\n}\r\n\r\n.footer a{\r\n    margin: 10px 30px;\r\n}\r\n\r\n.footer p{\r\n    margin-top: 15px;\r\n}\r\n\r\n@media screen and (max-width:768px){\r\n     .footer a{\r\n         margin: 10px 3%;\r\n     }\r\n }"

/***/ }),

/***/ "./src/app/forum/forum-footer/forum-footer.component.html":
/*!****************************************************************!*\
  !*** ./src/app/forum/forum-footer/forum-footer.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<footer class=\"footer text-center\">\n\t<div class=\"container\">\n\t\t<div class=\"row\">\n\t\t\t<div class=\"col-sm-12 icons\">\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-tencent-weibo white\"></i>\n\t\t\t\t</a>\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-weibo white\"></i>\n\t\t\t\t</a>\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-weixin white\"></i>\n\t\t\t\t</a>\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-skype white\"></i>\n\t\t\t\t</a>\n\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-twitter white\"></i>\n\t\t\t\t</a>\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-facebook white\"></i>\n\t\t\t\t</a>\n\t\t\t\t<a href=\"\">\n\t\t\t\t\t<i class=\"fa fa-linkedin white\"></i>\n\t\t\t\t</a>\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-12\">\n\t\t\t\t<p style=\"color:#eee;font-weight:lighter;\">COPYRIGHT &copy; 2017 CenoCloud+\n\t\t\t\t\t<a style=\"display:none;color:#ddd;font-weight:lighter;\">京ICP备17044594号-1</a>\n\t\t\t\t</p>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n</footer>"

/***/ }),

/***/ "./src/app/forum/forum-footer/forum-footer.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/forum/forum-footer/forum-footer.component.ts ***!
  \**************************************************************/
/*! exports provided: ForumFooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumFooterComponent", function() { return ForumFooterComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ForumFooterComponent = /** @class */ (function () {
    function ForumFooterComponent() {
    }
    ForumFooterComponent.prototype.ngOnInit = function () {
    };
    ForumFooterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-footer',
            template: __webpack_require__(/*! ./forum-footer.component.html */ "./src/app/forum/forum-footer/forum-footer.component.html"),
            styles: [__webpack_require__(/*! ./forum-footer.component.css */ "./src/app/forum/forum-footer/forum-footer.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ForumFooterComponent);
    return ForumFooterComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-index/forum-index.component.css":
/*!*************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-index.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".mymodal{\r\n    position: fixed;\r\n    left: 0;\r\n    top: 0;\r\n    height: 100%;\r\n    width: 100%;\r\n    background-color: rgba(0,0,0,0.5);\r\n    z-index: 9;\r\n}\r\n\r\n.mymodal-content{\r\n    position: absolute;\r\n    margin: auto;\r\n    left: 0;\r\n    right: 0;\r\n    top: 0;\r\n    bottom: 0;\r\n    width: 500px;\r\n    height: 250px;\r\n    background-color:#fff;\r\n    border-radius: 3px;\r\n}\r\n\r\n.modal-body{\r\n    padding: 30px 10%;\r\n}\r\n\r\n.modal-body label{\r\n    font-size: 14px;\r\n    line-height: 38px;\r\n    text-align: right;\r\n    width: 50px;\r\n    float: left;\r\n}\r\n\r\n.modal-body .input_div{\r\n    margin-left: 50px;\r\n    margin-right: 10px;\r\n}\r\n\r\n.modal-body input{\r\n    height: 38px;\r\n    box-sizing: border-box;\r\n    width: 100%;\r\n    border-radius: 3px;\r\n}\r\n\r\n.modal-footer{\r\n    border-top: none;\r\n    text-align: left;\r\n}\r\n\r\n.modal-footer a{\r\n    margin-left: 50px;\r\n    line-height: 40px;\r\n}\r\n\r\n.modal-footer button{\r\n    margin-right: 40px;\r\n    padding: 10px 15px;\r\n    float: right;\r\n}\r\n\r\n@media screen and (max-width:768px){\r\n    .mymodal-content{\r\n        width: 90%;\r\n        height: 300px;\r\n    }\r\n    \r\n    .modal-body{\r\n        padding: 30px 0%;\r\n    }\r\n\r\n    .modal-footer {\r\n        text-align: center;\r\n    }\r\n\r\n    .modal-footer button{\r\n        float: none;\r\n        margin-right: 0px;\r\n    }\r\n\r\n    .modal-footer a{\r\n        margin-left: 0px;\r\n        display: inline-block;\r\n    }\r\n    \r\n}"

/***/ }),

/***/ "./src/app/forum/forum-index/forum-index.component.html":
/*!**************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-index.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-forum-left class=\"col-sm-8 col-xs-12 forum-left\"></app-forum-left>\n<app-forum-right class=\"col-sm-4 hidden-xs forum-right\"></app-forum-right>\n\n<div *ngIf=\"modal\" class=\"mymodal\">\n    <div class=\"mymodal-content\">\n        <div class=\"modal-header\">\n            <h4 class=\"modal-title\" id=\"myModalLabel\">\n                欢迎加入CenoCloud开发者社区\n            </h4>\n        </div>\n        <div class=\"modal-body\">\n            <label for=\"nickname\">昵称</label>\n            <div class=\"input_div\">\n                <input type=\"text\" name=\"name\" id=\"nickname\" placeholder=\"请输入一个酷酷的昵称 ^_^\">\n            </div>\n        </div>\n        <div class=\"modal-footer\">\n            <button type=\"button\" class=\"btn btn-primary\" (click)=\"addName()\">\n                同意社区协议并加入社区\n            </button>\n            <a>CenoCloud社区用户协议</a>\n        </div>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-index/forum-index.component.ts":
/*!************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-index.component.ts ***!
  \************************************************************/
/*! exports provided: ForumIndexComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumIndexComponent", function() { return ForumIndexComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_forum_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../service/forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ng2-cookies/ng2-cookies */ "./node_modules/ng2-cookies/ng2-cookies.js");
/* harmony import */ var ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__);
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ForumIndexComponent = /** @class */ (function () {
    function ForumIndexComponent(forumService, router) {
        this.forumService = forumService;
        this.router = router;
        this.modal = false;
        this.uid = "";
        this.token = "";
    }
    ForumIndexComponent.prototype.ngOnInit = function () {
        var _this = this;
        //Cookie.deleteAll()
        // Cookie.set("uid","1",null,'/');
        // Cookie.set("token","UhZKj7i8YSrapGbIxeqa1g",null,'/');
        //console.log(document.cookie);
        this.uid = (ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].get('uid')).toString();
        this.token = ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].get('token') + "==";
        if (this.uid != "" && this.token != "") {
            // this.forumService.login(this.uid, this.token).then(res1=>{
            // 	if(res1.state==true){
            this.forumService.joinForum(this.uid, this.token).then(function (res2) {
                if (res2.state == true) {
                    ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].delete("authorId");
                    ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].set("authorId", res2.data.authorId, null, '/');
                    _this.forumService.getauthorId();
                    _this.modal = false;
                }
                else {
                    _this.modal = true;
                }
            });
            // 	}else{
            // 		this.modal=false;
            // 	}
            // });
        }
    };
    ForumIndexComponent.prototype.addName = function () {
        var _this = this;
        var name = $("#nickname").val().toString();
        if (name.length > 12) {
            alert("你能不能短一点");
            return;
        }
        this.forumService.addName(name, this.uid, this.token).then(function (res) {
            if (res.state == true) {
                ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].delete("authorId");
                ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].set("authorId", res.data.authorId);
                _this.forumService.getauthorId();
                _this.modal = false;
            }
            else {
                alert(res.msg);
            }
        });
    };
    ForumIndexComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-index',
            template: __webpack_require__(/*! ./forum-index.component.html */ "./src/app/forum/forum-index/forum-index.component.html"),
            styles: [__webpack_require__(/*! ./forum-index.component.css */ "./src/app/forum/forum-index/forum-index.component.css")]
        }),
        __metadata("design:paramtypes", [_service_forum_service__WEBPACK_IMPORTED_MODULE_1__["ForumService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ForumIndexComponent);
    return ForumIndexComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-index/forum-left/forum-left.component.css":
/*!***********************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-left/forum-left.component.css ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".forum-left img{\r\n    padding:0;\r\n}\r\n\r\n.index-left-ul{\r\n    background-color: #fff;\r\n    line-height: 4em;\r\n    list-style: none;\r\n    -webkit-margin-before:0;\r\n    -webkit-padding-start: 0px;\r\n    text-align: center;\r\n}\r\n\r\n.index-left-ul li{\r\n    cursor: pointer;\r\n    font-weight: bold;\r\n}\r\n\r\n.index-left-ul li:hover{\r\n    background-color: #f5f4f3;\r\n}\r\n\r\n.forum_li_active{\r\n    border-bottom:2px solid #36f;\r\n    color: #36f;\r\n}\r\n\r\n.index-left-content{\r\n    cursor: pointer;\r\n    position: relative;\r\n}\r\n\r\n.index-left-content .content-title h3{\r\n    font-size: 1.4em;\r\n    color: #373d41;\r\n    line-height: 140%;\r\n    font-weight: 300;\r\n}\r\n\r\n.index-left-content .content-title p{\r\n    font-size: 0.8em;\r\n    color: #9b9ea0;\r\n}\r\n\r\n.index-left-content:hover{\r\n    background-color: #f5f4f3;\r\n}\r\n\r\n.index-left-content+.index-left-content{\r\n    margin-top: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\n.content-bottom .col-sm-2{\r\n    padding: 0;\r\n}\r\n\r\n.content-bottom>div{\r\n    color: #9b9ea0;\r\n}\r\n\r\n@media screen and (max-width:768px){\r\n    .content-bottom .col-sm-2{\r\n        padding: 0 15px;\r\n    }\r\n\r\n    .index-left-content,.index-left-content .content-title{\r\n        height: 115px;\r\n    }\r\n    .index-left-content img{\r\n        padding-right: 15px;\r\n        padding-top: 29px;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/forum/forum-index/forum-left/forum-left.component.html":
/*!************************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-left/forum-left.component.html ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"forum-left\">\n\t<div class=\"row p1 wow zoomIn article_container bg-white\" data-wow-delay=\"0.4s\">\n\t\t<img class=\"col-md-12 col-sm-12 col-xs-12\" style=\"height: 25em;\" src=\"assets/img/bg.jpg\" />\n\t\t<!-- <div class=\"col-md-6 col-sm-12 col-xs-12\">\n\t\t\t<h3> 编程语言系列直播：Python、C++、Java、JavaScript四大编程...</h3>\n\t\t\t<p> 新年之后的社区第一趴系列直播——编程语言系列讲座中，我们邀请了行业资深专家和大家一起学习最流行的编程语言...</p>\n\t\t\t<p> 鲲云物联网通用服务</p>\n\t\t\t<p> 鲲云网联车整体解决方案 模组+云</p>\n\t\t\t<p> [福利] 问卷调查拿模组</p>\n\t\t</div> -->\n\t</div>\n\t<ul class=\"row index-left-ul\">\n\t\t<li class=\"col-md-2 col-sm-4 col-xs-3 p1 wow zoomIn forum_li_active\" data-wow-delay=\"0.4s\">\n\t\t\t推荐阅读\n\t\t</li>\n\t\t<li class=\"col-md-2 col-sm-2 col-xs-2 p1 wow zoomIn forum_li\" data-wow-delay=\"0.4s\">\n\t\t\t问答\n\t\t</li>\n\t\t<li class=\"col-md-2 col-sm-2 col-xs-2 p1 wow zoomIn forum_li\" data-wow-delay=\"0.4s\">\n\t\t\t极客\n\t\t</li>\n\t\t<li class=\"col-md-2 col-sm-2 col-xs-2 p1 wow zoomIn forum_li\" data-wow-delay=\"0.4s\">\n\t\t\t硬件\n\t\t</li>\n\t\t<li class=\"col-md-2 col-sm-2 col-xs-3 p1 wow zoomIn forum_li\" data-wow-delay=\"0.4s\">\n\t\t\t更多\n\t\t</li>\n\t</ul>\n\n\t<div [style.display]=\"load ? 'none' : 'block'\" class=\"height-load\">\n\t\t<i class=\"fa fa-spinner  fa-4x fa-pulse\"></i>\n\t</div>\n\n\t<div [style.display]=\"load ? 'block' : 'none'\" *ngFor=\"let art of article\" (click)=\"To_article(art.article.id)\" class=\"row p1 wow zoomIn article_container bg-white index-left-content\"\n\t data-wow-delay=\"0.4s\">\n\t\t<div class=\"col-md-8 col-sm-8 col-xs-8 content-title\">\n\t\t\t<h3>{{art.article.title}}</h3>\n\t\t\t<p class=\"hidden-xs\" [innerHTML]=\"art.article.abstractContent\">\n\t\t\t</p>\n\t\t\t<div class=\"row content-bottom\">\n\t\t\t\t<div class=\"col-md-3 col-sm-4 col-xs-6 hidden-xs\">{{art.author.nickName}}</div>\n\t\t\t\t<div class=\"col-md-3 col-sm-2 col-xs-6\">234人浏览</div>\n\t\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6 hidden-xs\">\n\t\t\t\t\t<a target=\"_blank\" [href]=\"art.article.fromWrl\">来自:{{art.article.fromWhere}}</a>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6\">{{art.article.modifyTime.split(\" \")[0]}}</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<img class=\"col-md-4 col-sm-4 col-xs-4\" src=\"assets/img/bg.jpg\" />\n\t</div>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-index/forum-left/forum-left.component.ts":
/*!**********************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-left/forum-left.component.ts ***!
  \**********************************************************************/
/*! exports provided: ForumLeftComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumLeftComponent", function() { return ForumLeftComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_forum_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../service/forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ForumLeftComponent = /** @class */ (function () {
    function ForumLeftComponent(forumindex, _router) {
        this.forumindex = forumindex;
        this._router = _router;
        this.load = false;
    }
    ;
    ForumLeftComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.forumindex.getForumIndexLeft()
            .then(function (res) {
            if (res.state == true) {
                console.log(res);
                _this.article = res.data;
                _this.load = true;
            }
        });
    };
    ForumLeftComponent.prototype.To_article = function (article_id) {
        this._router.navigate(['/forum/article', article_id]);
    };
    ForumLeftComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-left',
            template: __webpack_require__(/*! ./forum-left.component.html */ "./src/app/forum/forum-index/forum-left/forum-left.component.html"),
            styles: [__webpack_require__(/*! ./forum-left.component.css */ "./src/app/forum/forum-index/forum-left/forum-left.component.css")]
        }),
        __metadata("design:paramtypes", [_service_forum_service__WEBPACK_IMPORTED_MODULE_1__["ForumService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ForumLeftComponent);
    return ForumLeftComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-index/forum-right/forum-right.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-right/forum-right.component.css ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".forum-right{\r\n    margin-left: 10px;\r\n}\r\n\r\n.index-right-bottom>div{\r\n    margin-top: 1em;\r\n    background: #fff;\r\n    padding-bottom: 1em;\r\n}\r\n\r\n.index-right-bottom h3{\r\n    font-size:1em;\r\n    border-bottom: solid 1px #f8f8f8;\r\n    font-weight: lighter;\r\n    padding-bottom:0.5em;\r\n    font-size: 1.3em;\r\n}\r\n\r\n.index-right-bottom a{\r\n    color:#333;\r\n    padding-left:0.3em;\r\n    padding-right:0.3em;\r\n}\r\n\r\n.index-right-bottom ul{\r\n    padding-left: 1em;\r\n}\r\n\r\n.index-right-bottom ul li+li{\r\n    margin-top: 0.5em;\r\n}"

/***/ }),

/***/ "./src/app/forum/forum-index/forum-right/forum-right.component.html":
/*!**************************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-right/forum-right.component.html ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"forum-right\">\n\t<app-forum-right-function></app-forum-right-function>\n\t<div class=\"row index-right-bottom\">\n\t\t<div class=\"col-sm-12\">\n\t\t\t<h3>快速入口</h3>\n\t\t\t<a>IOT</a>\n\t\t\t<a>开发者控制台</a>\n\t\t\t<a>SDK</a>\n\t\t\t<a href=\"#\">Restful API</a>\n\t\t</div>\n\t\t<div class=\"col-sm-12\">\n\t\t\t<h3>活动消息</h3>\n\t\t</div>\n\t\t<div class=\"col-sm-12\">\n\t\t\t<h3>社区公告</h3>\n\t\t\t<ul>\n\t\t\t\t<li>Coding life，CenoCloud社区上线</li>\n\t\t\t\t<li>那些年，我们一起出书的日子！</li>\n\t\t\t\t<li>CenoCloud开发者社区合作指南</li>\n\t\t\t</ul>\n\t\t</div>\n\t\t<div class=\"col-sm-12\">\n\t\t\t<h3>合作伙伴</h3>\n\t\t\t<a>CenoCloud+</a>\n\t\t\t<a>MySql官方社区</a>\n\t\t</div>\n\n\t</div>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-index/forum-right/forum-right.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/forum/forum-index/forum-right/forum-right.component.ts ***!
  \************************************************************************/
/*! exports provided: ForumRightComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumRightComponent", function() { return ForumRightComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ForumRightComponent = /** @class */ (function () {
    function ForumRightComponent() {
        this.tick = 'assets/img/tick-2.svg';
    }
    ForumRightComponent.prototype.ngOnInit = function () {
    };
    ForumRightComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-right',
            template: __webpack_require__(/*! ./forum-right.component.html */ "./src/app/forum/forum-index/forum-right/forum-right.component.html"),
            styles: [__webpack_require__(/*! ./forum-right.component.css */ "./src/app/forum/forum-index/forum-right/forum-right.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ForumRightComponent);
    return ForumRightComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-nav/forum-nav.component.css":
/*!*********************************************************!*\
  !*** ./src/app/forum/forum-nav/forum-nav.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#top_cover{\r\n    background:rgb(55,61,65);\r\n    margin-bottom:2em;\r\n    width: 100%;\r\n    height: 40px;\r\n}\r\n\r\n.logo_div{\r\n    width: 200px;\r\n    float: left;\r\n    line-height: 40px;\r\n}\r\n\r\n.logo{\r\n    height: 30px;\r\n}\r\n\r\n.smallHide{\r\n    line-height: 40px;\r\n    float:right;\r\n    text-align:right;\r\n}\r\n\r\n.smallHide span,.smallHide a{\r\n    color: #fff;\r\n}\r\n\r\n.smallHide a{\r\n    padding-left:0.5em;\r\n    padding-right:0.5em;\r\n    font-weight:lighter;\r\n}\r\n\r\n@media screen and (max-width:768px){\r\n    #top_cover{\r\n        margin-bottom:0em;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/forum/forum-nav/forum-nav.component.html":
/*!**********************************************************!*\
  !*** ./src/app/forum/forum-nav/forum-nav.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"top_cover\">\n\t<div id=\"top_top\">\n\t\t<div class=\"logo_div\">\n\t\t\t<img src=\"assets/img/CenoCloudLogo.png\" alt=\"\" class=\"logo\">\n\t\t</div>\n\t\t<div class=\" smallHide hidden-xs\" style=\"float: right;\">\n\t\t\t<span class=\"fa fa-search\"></span>&nbsp;&nbsp;&nbsp;\n\t\t\t<a id=\"center\" href=\"./forum/index.html\">社区首页</a>\n\t\t\t<a id=\"center\" href=\"../mobile.html\">移动客户端</a>\n\t\t\t<a id=\"center\" href=\"../iot.html\">控制台</a>\n\t\t\t<a id=\"register\" href=\"../register.html\">注册</a>\n\t\t\t<a id=\"login\" href=\"../login.html\">登录</a>\n\t\t</div>\n\t</div>\n</div>\n<div class=\"clearfix\"></div>"

/***/ }),

/***/ "./src/app/forum/forum-nav/forum-nav.component.ts":
/*!********************************************************!*\
  !*** ./src/app/forum/forum-nav/forum-nav.component.ts ***!
  \********************************************************/
/*! exports provided: ForumNavComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumNavComponent", function() { return ForumNavComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ForumNavComponent = /** @class */ (function () {
    function ForumNavComponent() {
    }
    ForumNavComponent.prototype.ngOnInit = function () {
    };
    ForumNavComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-nav',
            template: __webpack_require__(/*! ./forum-nav.component.html */ "./src/app/forum/forum-nav/forum-nav.component.html"),
            styles: [__webpack_require__(/*! ./forum-nav.component.css */ "./src/app/forum/forum-nav/forum-nav.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ForumNavComponent);
    return ForumNavComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-new/forum-new.component.css":
/*!*********************************************************!*\
  !*** ./src/app/forum/forum-new/forum-new.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".new-title{\r\n    line-height: 60px;\r\n    background-color: #fff;\r\n    padding: 0;\r\n    text-align: center;\r\n    cursor: pointer;\r\n}\r\n\r\n.new-title .active{\r\n    color: #36f;\r\n    border-bottom: 1px solid #36f;\r\n}\r\n\r\n.article_container{\r\n    background-color: #fff;\r\n    margin-top: 10px;\r\n    padding-top: 20px;\r\n    padding-bottom: 20px;\r\n}\r\n\r\n.article_container label {\r\n    vertical-align: 2px;\r\n}\r\n\r\n.new-title2 label{\r\n    line-height: 38px;\r\n    text-align: left;\r\n}\r\n\r\n.new-title2 input{\r\n    width: 100%;\r\n    height: 38px;\r\n    box-sizing: border-box;\r\n}\r\n\r\n.input{\r\n    height: 38px;\r\n    margin: 10px 15px;\r\n    box-sizing: border-box;\r\n}\r\n\r\n.editor{\r\n    margin-top: 10px;\r\n}\r\n\r\n.new-title2 label[for='verify-input']{\r\n    width: 75px;\r\n    padding: 0 15px;\r\n    float: left;\r\n}\r\n\r\n.type input[type=radio]{\r\n    float: left;\r\n    margin-top: 8px;\r\n    zoom: 120%;\r\n}\r\n\r\n.type label{\r\n    display: block;\r\n    margin-left: 12px;\r\n    margin-top: 9px;\r\n}\r\n"

/***/ }),

/***/ "./src/app/forum/forum-new/forum-new.component.html":
/*!**********************************************************!*\
  !*** ./src/app/forum/forum-new/forum-new.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n\t<!-- <div [style.display]=\"load ? 'none' : 'block'\" class=\"col-sm-8 col-xs-12 height-load\">\n\t\t<i class=\"fa fa-spinner  fa-4x fa-pulse\"></i>\n\t</div> -->\n\t<div class=\"animated fadeInLeft col-sm-8\">\n\t\t<div class=\"row new-title\">\n\t\t\t<div class=\"col-sm-3 active\">\n\t\t\t\t写文章\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t<label class=\"col-sm-1 col-xs-2\" for=\"title-input\">标题</label>\n\t\t\t<div class=\"col-md-12 col-xs-12\">\n\t\t\t\t<input type=\"text\" id=\"title-input\" placeholder=\"华丽的跌倒，胜过无谓的徘徊！\" />\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-12 col-xs-12 editor\">\n\t\t\t\t<quill-editor id=\"editor\"></quill-editor>\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div class=\"row p1 wow zoomIn article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t<label class=\"col-sm-12 col-xs-2\" for=\"tag-input\">标签</label>\n\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t<input type=\"text\" id=\"tag-input\" placeholder=\"华丽的跌倒，胜过无谓的徘徊！\" />\n\t\t\t</div>\n\t\t</div>\n\n\t\t<div class=\"row p1 wow zoomIn article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t<label class=\"col-sm-12 col-xs-12\" for=\"abs-input\">摘要\n\t\t\t\t<i style=\"color:#bbb;\">默认自动提取您文章的前150字显示在文章摘要的位置，您也可以在这里自行编辑，限150字。</i>\n\t\t\t</label>\n\t\t\t<div class=\"col-md-12 col-xs-12\">\n\t\t\t\t<input type=\"text\" id=\"abs-input\" placeholder=\"华丽的跌倒，胜过无谓的徘徊！\" />\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t<p>关闭评论</p>\n\t\t\t\t<input type=\"checkbox\" name=\"article_comment\" value=\"1\" id=\"article_comment\">\n\t\t\t\t<label for=\"article_comment\">本文章不允许别人评论</label>\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container type\" data-wow-delay=\"0.4s\">\n\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t<p>文章类型</p>\n\t\t\t\t<input type=\"radio\" name=\"article_type\" value=\"1\" id=\"article_type1\" checked />\n\t\t\t\t<label for=\"article_type1\" class=\"two_line\">原创文章<br>(经验总结等原创好文将有更多被推荐的机会)</label>\n\t\t\t\t<div class=\"row hidden\">\n\t\t\t\t\t<input class=\"col-sm-5 col-xs-11 input\" type=\"hidden\" name=\"from_where1\" value=\"原创\">\n\t\t\t\t\t<input class=\"col-sm-5 col-xs-11 input\" type=\"hidden\" name=\"from_url1\" value=\"#\">\n\t\t\t\t</div>\n\n\t\t\t\t<br>\n\t\t\t\t<input type=\"radio\" name=\"article_type\" value=\"2\" id=\"article_type2\">\n\t\t\t\t<label for=\"article_type2\">翻译文章</label>\n\t\t\t\t<div class=\"row\" *ngIf=\"article_type1==2\" >\n\t\t\t\t\t<input class=\"col-sm-5 col-xs-11 input\" type=\"text\" name=\"from_where2\" placeholder=\"出自哪里\">\n\t\t\t\t\t<input class=\"col-sm-5 col-xs-11 input\" type=\"text\" name=\"from_url2\" placeholder=\"url\">\n\t\t\t\t</div>\n\t\t\t\t<br>\n\t\t\t\t<input type=\"radio\" name=\"article_type\" value=\"3\" id=\"article_type3\">\n\t\t\t\t<label for=\"article_type3\">转载文章</label>\n\t\t\t\t<div class=\"row\" *ngIf=\"article_type1==3\" >\n\t\t\t\t\t<input class=\"col-sm-5 col-xs-11 input\" type=\"text\" name=\"from_where3\" placeholder=\"出自哪里\">\n\t\t\t\t\t<input class=\"col-sm-5 col-xs-11 input\" type=\"text\" name=\"from_url3\" placeholder=\"url\">\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t<label for=\"verify-input\">验证</label>\n\t\t\t<div class=\"col-md-11 col-sm-10 col-xs-9\">\n\t\t\t\t<input placeholder=\"输入验证码内容\" id=\"verify-input\" style=\"width: 150px;\" />\n\t\t\t\t<img style=\"height: 38px\" src=\"https://api.sso.cenocloud.com/login/nasde/create\" />\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t<p>免责申明:用户承诺，自主发表的文章不存在任何知识产权问题，否则用户应自行承担全部责任，鲲云社区有权为权利人维权进行必要的配合。</p>\n\t\t\t\t<button (click)=\"addNew()\" class=\"col-sm-3 col-sm-offset-0 col-xs-6 col-xs-offset-3\" style=\"background: #36f;color:#fff;font-weight: bold;height: 3em;line-height: 3em;border:none;\">发布</button>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\n\t<div class=\"animated col-sm-4 hidden-xs\">\n\t\t<div style=\"margin-left: 10px;\">\n\t\t\t<app-forum-right-function></app-forum-right-function>\n\t\t</div>\n\t</div>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-new/forum-new.component.ts":
/*!********************************************************!*\
  !*** ./src/app/forum/forum-new/forum-new.component.ts ***!
  \********************************************************/
/*! exports provided: ForumNewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumNewComponent", function() { return ForumNewComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_forum_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../service/forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



// import { Simditor } from 'simditor';
var ForumNewComponent = /** @class */ (function () {
    function ForumNewComponent(forumService, router) {
        this.forumService = forumService;
        this.router = router;
        this.article_type1 = 1;
        this.article_comment = 0;
    }
    ForumNewComponent.prototype.ngOnInit = function () {
        change_editor();
        function change_editor() {
            $("#editor").on("click", ".ql-image2", function () {
                $(".ql-editing2").removeClass("ql-hidden");
            });
            $("#editor").on("click", "button[data-mode!=image]", function () {
                $(".ql-editing2").addClass("ql-hidden");
            });
            $("#editor").on("click", ".ql-action2", function () {
                var x = $("#editor input[data-image=image]").val();
                if (x == "") {
                    $(".ql-editing2").addClass("ql-hidden");
                }
                else {
                    $(".ql-editor").append('<img src="' + x + '"></img>');
                    $(".ql-editing2").addClass("ql-hidden");
                }
            });
        }
        var top = this;
        $("input[name=article_type]").each(function () {
            $(this).click(function () {
                top.article_type1 = Number($(this).val());
            });
        });
        $("input[name=article_comment]").click(function () {
            top.article_comment = Number(!top.article_comment);
        });
    };
    ForumNewComponent.prototype.ngAfterViewInit = function () {
        $("#editor .ql-toolbar .ql-formats:last").append('<button type="button" class="ql-image2" data-mode="image">' +
            '<svg viewBox="0 0 18 18">' +
            '<rect class="ql-stroke" height="10" width="12" x="3" y="4"></rect> ' +
            '<circle class="ql-fill" cx="6" cy="7" r="1"></circle> ' +
            '<polyline class="ql-even ql-fill" points="5 12 5 11 7 9 8 10 11 7 13 9 13 12 5 12">' +
            '</polyline> </svg></button>');
        $(".ql-container").append('<div class="ql-tooltip ql-hidden ql-editing ql-editing2" data-mode="image"><a class="ql-preview" target="_blank" href="about:blank"></a><input type="text" data-formula="e=mc^2" data-link="https://quilljs.com" data-image="image" placeholder="Embed URL"><a class="ql-action ql-action2"></a><a class="ql-remove2"></a></div>');
    };
    ForumNewComponent.prototype.addNew = function () {
        var _this = this;
        var type = this.article_type1;
        var data = {
            title: $("#title-input").val(),
            content: $("#editor .ql-editor").html(),
            tags: $("#tag-input").val(),
            abstractContent: $("#abs-input").val(),
            canComment: Number(this.article_comment),
            type: Number(this.article_type1),
            fromWhere: $("input[name=from_where" + type + "]").val(),
            fromUrl: $("input[name=from_url" + type + "]").val()
        };
        this.forumService.publishNew(data).then(function (res) {
            if (res.state == true) {
                alert("发表成功");
                setTimeout(_this.router.navigate(['/forum/index']), 1000);
            }
        });
    };
    ForumNewComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-new',
            template: __webpack_require__(/*! ./forum-new.component.html */ "./src/app/forum/forum-new/forum-new.component.html"),
            styles: [__webpack_require__(/*! ./forum-new.component.css */ "./src/app/forum/forum-new/forum-new.component.css")]
        }),
        __metadata("design:paramtypes", [_service_forum_service__WEBPACK_IMPORTED_MODULE_1__["ForumService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ForumNewComponent);
    return ForumNewComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-question-detail/forum-question-detail.component.css":
/*!*********************************************************************************!*\
  !*** ./src/app/forum/forum-question-detail/forum-question-detail.component.css ***!
  \*********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".new-title{\r\n    line-height: 60px;\r\n    background-color: #fff;\r\n    padding: 0;\r\n    text-align: center;\r\n    cursor: pointer;\r\n}\r\n\r\n.new-title .active{\r\n    color: #36f;\r\n    border-bottom: 1px solid #36f;\r\n}\r\n\r\n.article_container{\r\n    background-color: #fff;\r\n    margin-top: 10px;\r\n    padding-top: 20px;\r\n    padding-bottom: 20px;\r\n}\r\n\r\n.question>div{\r\n    margin-top:30px;\r\n    margin-bottom:30px;\r\n}\r\n\r\n.form_group{\r\n    margin-top: 10px;\r\n    margin-bottom: 10px;\r\n}\r\n"

/***/ }),

/***/ "./src/app/forum/forum-question-detail/forum-question-detail.component.html":
/*!**********************************************************************************!*\
  !*** ./src/app/forum/forum-question-detail/forum-question-detail.component.html ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n\t<div [style.display]=\"load ? 'none' : 'block'\" class=\"col-sm-8 col-xs-12 height-load\">\n\t\t<i class=\"fa fa-spinner  fa-4x fa-pulse\"></i>\n\t</div>\n\t<div [style.display]=\"load ? 'block' : 'none'\" class=\"col-sm-8 col-xs-12\"  *ngFor=\"let ques_de of question_detail\">\n\t\t<div class=\"row new-title\" >\n\t\t\t<div class=\"col-sm-3 active\">\n\t\t\t\t问题详情\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container question\" data-wow-delay=\"0.4s\">\n\t\t\t<h1 class=\"col-sm-12 col-xs-12 text-center\">{{ques_de.question.title}}</h1>\n\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t<div class=\"col-sm-3 col-xs-6\">\n\t\t\t\t\t{{ques_de.author.nickName}}\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-sm-3 col-xs-6\">\n\t\t\t\t\t{{ques_de.question.modifyTime.split(\" \")[0]}}\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-sm-3 col-xs-6\">\n\t\t\t\t\t{{ques_de.question.starCount}}人点赞\n\t\t\t\t</div>\n\t\t\t\t<div class=\"col-sm-3 col-xs-6\">\n\t\t\t\t\t{{ques_de.question.answerCount}}人回答\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\t\t<div class=\"col-sm-12 col-xs-12\" [innerHTML]=\"ques_de.question.content\">\n\t\t\t</div>\n\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t<div class=\"col-sm-12 col-xs-12 form_group\">\n\t\t\t\t<div class=\"editor\">\n\t\t\t\t\t<div class=\"editor-container\">\n\t\t\t\t\t\t<textarea name=\"answer\" rows=\"4\" class=\"form-control js-mention js-auto-expand editor-content\" id=\"comment\" placeholder=\"写下你的评论…\"\n\t\t\t\t\t\t required=\"\"></textarea>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-12 col-xs-12 form_group\">\n\t\t\t\t<input type=\"text\" placeholder=\"输入验证码内容\" />\n\t\t\t\t<img style=\"height:38px;\" src=\"https://api.sso.cenocloud.com/login/nasde/create\" />\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-3 col-xs-6 form_group\">\n\t\t\t\t<button (click)=\"addAnswer()\" type=\"submit\" class=\"answer_button\" style=\"width:100%;background: #36f;color:#fff;font-weight: bold;height: 3em;line-height: 3em;border:none;\">回答</button>\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\" *ngFor=\"let ans of question_detail[0].answers\">\n\t\t\t<div class=\"col-md-3 col-sm-3 col-xs-6\">\n\t\t\t\t<div [ngStyle]=\"{'background-color':ans.answer.isAccept == 1 ? 'green' : 'orange' }\" style=\"display:inline-block;height:40px;width:42px;padding: 6px;\">\n\t\t\t\t\t<img *ngIf=\"ans.answer.isAccept == 1\" style=\"height: 28px;\" src=\"assets/img/zan_click.svg\" />\n\t\t\t\t\t<img *ngIf=\"ans.answer.isAccept == 0\" style=\"height: 28px;\" src=\"assets/img/zan.svg\" />\n\t\t\t\t</div>\n\t\t\t\t<div [ngStyle]=\"{'color':ans.answer.isAccept == 1 ? 'green' : 'orange' ,'border':ans.answer.isAccept == 1 ? 'solid 1px green':'solid 1px orange'}\"\n\t\t\t\t style=\"display:inline-block;text-align:center;background: #f8f8f8;line-height:38px;width: 48px;vertical-align: bottom\">\n\t\t\t\t\t{{ans.answer.starCount}}\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\t\t<div class=\"col-md-9 col-sm-9 col-xs-12 list-detail\">\n\t\t\t\t<div class=\"row\">\n\t\t\t\t\t<div class=\"col-sm-12 col-xs-12\" style=\"margin-bottom: 10px;\">\n\t\t\t\t\t\t{{ans.answer.content}} \n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"col-sm-3 col-xs-6 text-left\" style=\"color:#000;\">{{ans.author.nickName}}</div>\n\t\t\t\t\t<div class=\"col-sm-3 col-xs-6 text-left\">{{ans.answer.modifyTime.split(\" \")[0]}}</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\n\t<div class=\"col-sm-4 hidden-xs\">\n\t\t<div style=\"margin-left: 10px;\">\n\t\t\t<app-forum-right-function></app-forum-right-function>\n\t\t</div>\n\t</div>\n\n\t<app-modal-log #modal></app-modal-log>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-question-detail/forum-question-detail.component.ts":
/*!********************************************************************************!*\
  !*** ./src/app/forum/forum-question-detail/forum-question-detail.component.ts ***!
  \********************************************************************************/
/*! exports provided: ForumQuestionDetailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumQuestionDetailComponent", function() { return ForumQuestionDetailComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_forum_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../service/forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../modal-log/modal-log.component */ "./src/app/forum/modal-log/modal-log.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ForumQuestionDetailComponent = /** @class */ (function () {
    function ForumQuestionDetailComponent(forumService, route) {
        this.forumService = forumService;
        this.route = route;
        this.question_id = Number(this.route.snapshot.params['id']);
        this.question_detail = [];
        this.load = false;
    }
    ForumQuestionDetailComponent.prototype.ngOnInit = function () {
        this.getQuestionDetail();
    };
    ForumQuestionDetailComponent.prototype.getQuestionDetail = function () {
        var _this = this;
        this.forumService.QuestionDetail(this.question_id).then(function (res) {
            if (res.state == true) {
                _this.question_detail[0] = res.data;
                _this.load = true;
            }
            else {
                _this.modal.show(res.msg, "1500");
            }
        });
    };
    ForumQuestionDetailComponent.prototype.addAnswer = function () {
        var _this = this;
        var answer = $("textarea[name='answer']").val();
        if (answer == "") {
            this.modal.show("回答不能为空", "1500");
            return;
        }
        var data = {
            questionId: this.question_id,
            answer: answer
        };
        this.forumService.publishAnswer(data).then(function (res) {
            if (res.state == true) {
                _this.modal.show("感谢回答 ^_^", "1500");
                _this.question_detail[0].answers.unshift(res.data);
                console.log(_this.question_detail);
                $("textarea[name='answer']").val('');
            }
            else {
                _this.modal.show(res.msg, "1500");
            }
        });
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])("modal"),
        __metadata("design:type", _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_3__["ModalLogComponent"])
    ], ForumQuestionDetailComponent.prototype, "modal", void 0);
    ForumQuestionDetailComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-question-detail',
            template: __webpack_require__(/*! ./forum-question-detail.component.html */ "./src/app/forum/forum-question-detail/forum-question-detail.component.html"),
            styles: [__webpack_require__(/*! ./forum-question-detail.component.css */ "./src/app/forum/forum-question-detail/forum-question-detail.component.css")]
        }),
        __metadata("design:paramtypes", [_service_forum_service__WEBPACK_IMPORTED_MODULE_1__["ForumService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
    ], ForumQuestionDetailComponent);
    return ForumQuestionDetailComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-question/forum-question.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/forum/forum-question/forum-question.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".new-title{\r\n    line-height: 60px;\r\n    background-color: #fff;\r\n    padding: 0;\r\n    text-align: center;\r\n    cursor: pointer;\r\n    position: relative;\r\n}\r\n\r\n.new-title .active{\r\n    color: #36f;\r\n}\r\n\r\n.new-title .underline{\r\n    position: absolute;\r\n    top: 100%;\r\n    border-bottom: 1px solid #36f;\r\n    transition: all .5s ease;\r\n}\r\n\r\n.the_left{\r\n    overflow: hidden;\r\n    width: 66.6%;\r\n    float: left;\r\n}\r\n\r\n.article_container{\r\n    background-color: #fff;\r\n    margin-top: 10px;\r\n    padding-top: 20px;\r\n    padding-bottom: 20px;\r\n}\r\n\r\n.article_container input {\r\n    vertical-align: top;\r\n}\r\n\r\n.new-title2 label{\r\n    line-height: 38px;\r\n    text-align: left;\r\n}\r\n\r\n.new-title2 input{\r\n    width: 100%;\r\n    height: 38px;\r\n    box-sizing: border-box;\r\n}\r\n\r\n.editor{\r\n    margin-top: 10px;\r\n}\r\n\r\n.new-title2 label[for='verify-input']{\r\n    width: 75px;\r\n    padding: 0 15px;\r\n    float: left;\r\n}\r\n\r\n.isquestion{\r\n    width: 200%;\r\n    left: 0%;\r\n    position: relative;\r\n    transition: left .5s ease;\r\n}\r\n\r\n.question,.questionlist{\r\n    float: left;\r\n    width: 50%;\r\n    padding: 0 15px;\r\n}\r\n\r\n.question,.questionlist>div{\r\n    cursor: pointer;\r\n}\r\n\r\n.type input[type=radio],.type label{\r\n    display: inline-block;\r\n    margin-top: 8px;\r\n}\r\n\r\n.type input[type=radio]{\r\n    vertical-align: -3px;\r\n    zoom: 120%;\r\n}\r\n\r\n@media screen and (max-width:768px){\r\n    .the_left{\r\n        width: 100%;\r\n    }\r\n\r\n    .questionlist .list-detail{\r\n        margin-top: 30px;\r\n    }\r\n}"

/***/ }),

/***/ "./src/app/forum/forum-question/forum-question.component.html":
/*!********************************************************************!*\
  !*** ./src/app/forum/forum-question/forum-question.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n\t<!-- <div [style.display]=\"load ? 'none' : 'block'\" class=\"col-sm-8 col-xs-12 height-load\">\n      <i class=\"fa fa-spinner  fa-4x fa-pulse\"></i>\n    </div> -->\n\t<div class=\"animated fadeInLeft the_left\">\n\t\t<div class=\"new-title\">\n\t\t\t<div class=\"col-sm-2 col-xs-6 active\" (click)=\"question()\">\n\t\t\t\t提问题\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-2 col-xs-6\" (click)=\"questionlist()\">\n\t\t\t\t问答\n\t\t\t</div>\n\t\t\t<div class=\"col-sm-2 col-xs-6 underline\"></div>\n\t\t\t<div class=\"clearfix\"></div>\n\t\t</div>\n\t\t<div class=\"isquestion\">\n\t\t\t<div class=\"question\">\n\t\t\t\t<div class=\"row p1 wow article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t\t\t<label class=\"col-sm-12 col-xs-12\" for=\"title-input\">标题\n\t\t\t\t\t\t<i style=\"color:#bbb;\">用一句话说清楚你的问题</i>\n\t\t\t\t\t</label>\n\t\t\t\t\t<div class=\"col-md-12 col-xs-12\">\n\t\t\t\t\t\t<input id=\"title-input\" placeholder=\"华丽的跌倒，胜过无谓的徘徊！\" />\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"col-sm-12 col-xs-12 editor\">\n\t\t\t\t\t\t<quill-editor id=\"editor\">\n\t\t\t\t\t\t</quill-editor>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\n\t\t\t\t<div class=\"row p1 wow zoomIn article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t\t\t<label class=\"col-sm-12 col-xs-2\" for=\"tag-input\">标签</label>\n\t\t\t\t\t<div class=\"col-md-12 col-xs-12\">\n\t\t\t\t\t\t<input id=\"tag-input\" placeholder=\"华丽的跌倒，胜过无谓的徘徊！\" />\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"row p1 wow zoomIn article_container type\" data-wow-delay=\"0.4s\">\n\t\t\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t\t\t<p>问题类型</p>\n\t\t\t\t\t\t<input type=\"radio\" name=\"article_type\" value=\"1\" id=\"article_type1\" checked>\n\t\t\t\t\t\t<label for=\"article_type1\">一般技术问题</label>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<input type=\"radio\" name=\"article_type\" value=\"2\" id=\"article_type2\">\n\t\t\t\t\t\t<label for=\"article_type2\">鲲云技术问题</label>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"row p1 wow zoomIn article_container new-title2\" data-wow-delay=\"0.4s\">\n\t\t\t\t\t<label for=\"verify-input\">验证</label>\n\t\t\t\t\t<div class=\"col-md-8 col-sm-8 col-xs-9\">\n\t\t\t\t\t\t<input placeholder=\"输入验证码内容\" id=\"verify-input\" style=\"width: 150px;\" />\n\t\t\t\t\t\t<img style=\"height: 38px\" src=\"https://api.sso.cenocloud.com/login/nasde/create\" />\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t\t\t<div class=\"col-sm-12 col-xs-12\">\n\t\t\t\t\t\t<p>免责申明:用户承诺，自主发表的文章不存在任何知识产权问题，否则用户应自行承担全部责任，鲲云社区有权为权利人维权进行必要的配合。</p>\n\t\t\t\t\t\t<button (click)=\"publish_question()\" class=\"col-sm-3 col-sm-offset-0 col-xs-6 col-xs-offset-3\" style=\"background: #36f;color:#fff;font-weight: bold;height: 3em;line-height: 3em;border:none;\">发布</button>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"questionlist\">\n\t\t\t\t<div *ngFor=\"let ques of questionList\" (click)=\"go_question_detail(ques.question.id)\"  class=\"row p1 wow zoomIn article_container\" data-wow-delay=\"0.4s\">\n\t\t\t\t\t<div class=\"col-md-3 col-sm-6 col-xs-6\">\n\t\t\t\t\t\t<div [ngStyle]=\"{'background-color':ques.question.accept == 1 ? 'green' : 'orange' }\" style=\"display:inline-block;height:40px;width:42px;padding: 6px;\">\n\t\t\t\t\t\t\t<img *ngIf=\"ques.question.accept == 1\"  style=\"height: 28px;\" src=\"assets/img/accept.svg\" />\n\t\t\t\t\t\t\t<img *ngIf=\"ques.question.accept == 0\"  style=\"height: 28px;\" src=\"assets/img/waiting.svg\" />\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div [ngStyle]=\"{'color':ques.question.accept == 1 ? 'green' : 'orange' ,'border':ques.question.accept == 1 ? 'solid 1px green':'solid 1px orange'}\" style=\"display:inline-block;text-align:center;background: #f8f8f8;line-height:38px;width: 48px;vertical-align: bottom\">\n\t\t\t\t\t\t\t{{ques.question.answerCount}}\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"col-md-2 col-sm-6 col-xs-6\" style=\"line-height: 3em;font-weight: bold;\">\n\t\t\t\t\t\t{{(ques.question.accept==1)?\"已采纳\":\"求解答\"}}\n\t\t\t\t\t</div>\n\n\t\t\t\t\t<div class=\"col-md-7 col-sm-12 col-xs-12 list-detail\">\n\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t<p class=\"col-sm-12 col-xs-12\">{{ques.question.title}}</p>\n\t\t\t\t\t\t\t<div class=\"col-sm-4 col-xs-4\" style=\"text-align:left;color:#000;\">{{ques.author.nickName}}</div>\n\t\t\t\t\t\t\t<div class=\"col-sm-4 col-xs-4\" style=\"text-align:left;\">{{ques.question.modifyTime.split(\" \")[0]}}</div>\n\t\t\t\t\t\t\t<div class=\"col-sm-4 col-xs-4\" style=\"text-align:left;\">{{ques.question.starCount}}人点赞</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\n\t<div class=\"col-sm-4 hidden-xs animated\">\n\t\t<div style=\"margin-left: 10px;\">\n\t\t\t<app-forum-right-function></app-forum-right-function>\n\t\t</div>\n\t</div>\n\n\t<app-modal-log #modal></app-modal-log>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-question/forum-question.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/forum/forum-question/forum-question.component.ts ***!
  \******************************************************************/
/*! exports provided: ForumQuestionComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumQuestionComponent", function() { return ForumQuestionComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_forum_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../service/forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../modal-log/modal-log.component */ "./src/app/forum/modal-log/modal-log.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ForumQuestionComponent = /** @class */ (function () {
    function ForumQuestionComponent(forumService, router) {
        this.forumService = forumService;
        this.router = router;
        this.article_type1 = 1;
        this.questionList = [];
        this.page = 0;
    }
    ForumQuestionComponent.prototype.ngOnInit = function () {
        this.init();
        // $('#example-offset-pixels').waypoint(function() { 
        //   }, { offset: 100 }); 
        var top = this;
        $("input[name=article_type]").each(function () {
            $(this).click(function () {
                top.article_type1 = Number($(this).val());
            });
        });
        change_editor();
        function change_editor() {
            $("#editor").on("click", ".ql-image2", function () {
                $(".ql-editing2").removeClass("ql-hidden");
            });
            $("#editor").on("click", "button[data-mode!=image]", function () {
                $(".ql-editing2").addClass("ql-hidden");
            });
            $("#editor").on("click", ".ql-action2", function () {
                var x = $("#editor input[data-image=image]").val();
                if (x == "") {
                    $(".ql-editing2").addClass("ql-hidden");
                }
                else {
                    $(".ql-editor").append('<img src="' + x + '">');
                    $(".ql-editing2").addClass("ql-hidden");
                }
            });
        }
        ;
    };
    ForumQuestionComponent.prototype.ngAfterViewInit = function () {
        $("#editor .ql-toolbar .ql-formats:last").append('<button type="button" class="ql-image2" data-mode="image">' +
            '<svg viewBox="0 0 18 18">' +
            '<rect class="ql-stroke" height="10" width="12" x="3" y="4"></rect> ' +
            '<circle class="ql-fill" cx="6" cy="7" r="1"></circle> ' +
            '<polyline class="ql-even ql-fill" points="5 12 5 11 7 9 8 10 11 7 13 9 13 12 5 12">' +
            '</polyline> </svg></button>');
        $(".ql-container").append('<div class="ql-tooltip ql-hidden ql-editing ql-editing2" data-mode="image"><a class="ql-preview" target="_blank" href="about:blank"></a><input type="text" data-formula="e=mc^2" data-link="https://quilljs.com" data-image="image" placeholder="Embed URL"><a class="ql-action ql-action2"></a><a class="ql-remove2"></a></div>');
    };
    ForumQuestionComponent.prototype.question = function () {
        $(".isquestion").css("left", "0%");
        $(".new-title div:eq(1)").removeClass("active");
        $(".new-title div:eq(0)").addClass("active");
        $(".underline").removeClass("col-sm-offset-2");
        $(".underline").removeClass("col-xs-offset-6");
    };
    ForumQuestionComponent.prototype.questionlist = function () {
        $(".new-title div:eq(0)").removeClass("active");
        $(".new-title div:eq(1)").addClass("active");
        $(".underline").addClass("col-sm-offset-2");
        $(".underline").addClass("col-xs-offset-6");
        $(".isquestion").css("left", "-100%");
    };
    ForumQuestionComponent.prototype.init = function () {
        var _this = this;
        this.forumService.getQuestionList(this.page).then(function (res) {
            var top = _this;
            if (res.state == true) {
                _this.questionList = res.data;
                console.log(_this.questionList);
            }
            else {
                _this.modal.show(res.msg, "1500");
            }
        });
    };
    ForumQuestionComponent.prototype.publish_question = function () {
        var _this = this;
        console.log(document.cookie);
        var type = this.article_type1;
        var data = {
            title: $("#title-input").val(),
            content: $("#editor .ql-editor").html(),
            tags: $("#tag-input").val(),
            type: Number(this.article_type1),
        };
        this.forumService.publishQuestion(data).then(function (res) {
            var top = _this;
            if (res.state == true) {
                $("#title-input").val(''),
                    $("#editor .ql-editor").html(''),
                    $("#tag-input").val(''),
                    _this.modal.show("提问成功", "1500");
                setTimeout(function () {
                    top.init();
                    top.questionlist();
                }, 1500);
            }
            else {
                _this.modal.show(res.msg, "1500");
            }
        });
    };
    ForumQuestionComponent.prototype.go_question_detail = function (id) {
        this.router.navigate(['/forum/questionDetail', id]);
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])("modal"),
        __metadata("design:type", _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_3__["ModalLogComponent"])
    ], ForumQuestionComponent.prototype, "modal", void 0);
    ForumQuestionComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-question',
            template: __webpack_require__(/*! ./forum-question.component.html */ "./src/app/forum/forum-question/forum-question.component.html"),
            styles: [__webpack_require__(/*! ./forum-question.component.css */ "./src/app/forum/forum-question/forum-question.component.css")]
        }),
        __metadata("design:paramtypes", [_service_forum_service__WEBPACK_IMPORTED_MODULE_1__["ForumService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ForumQuestionComponent);
    return ForumQuestionComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-right-function/forum-right-function.component.css":
/*!*******************************************************************************!*\
  !*** ./src/app/forum/forum-right-function/forum-right-function.component.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".right_item{\r\n    background-color: #fff;\r\n    cursor: pointer;\r\n}\r\n\r\n.right_item+.right_item{\r\n    border-left: solid 1px #f8f8f8;\r\n}\r\n\r\n.right_item:hover p{\r\n    color:#2E60FF;\r\n}\r\n\r\n.right_item img{\r\n    -webkit-filter: grayscale(100%);\r\n            filter: grayscale(100%);\r\n    padding: 30% 30% 10% 30%;\r\n    color: #000;\r\n}\r\n\r\n.right_item:hover img{\r\n    -webkit-filter: grayscale(0);\r\n            filter: grayscale(0);\r\n}\r\n\r\n.right_item p{\r\n    text-align: center;\r\n}\r\n"

/***/ }),

/***/ "./src/app/forum/forum-right-function/forum-right-function.component.html":
/*!********************************************************************************!*\
  !*** ./src/app/forum/forum-right-function/forum-right-function.component.html ***!
  \********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n\t<div class=\"col-sm-4 right_item\">\n\t\t<img class=\"col-sm-12\" src=\"assets/img/tick-1.svg\">\n\t\t<p>打卡</p>\n\t</div>\n\t<div class=\"col-sm-4 right_item\" (click)=\"skip('/forum/new')\">\n\t\t<img class=\"col-sm-12\" src=\"assets/img/pen-1.svg\">\n\t\t<p> 写文章</p>\n\t</div>\n\t<div class=\"col-sm-4 right_item\" (click)=\"skip('/forum/question')\">\n\t\t<img class=\"col-sm-12\" src=\"assets/img/why-1.svg\">\n\t\t<p>提问题</p>\n\t</div>\n</div>\n\n<div class=\"row\">\n\t<div class=\"col-sm-4 right_item\">\n\t\t<img class=\"col-sm-12\" src=\"assets/img/paihang.svg\">\n\t\t<p>文章排行</p>\n\t</div>\n\t<div class=\"col-sm-4 right_item\">\n\t\t<img class=\"col-sm-12\" src=\"assets/img/jiangpai.svg\">\n\t\t<p> 博主排行</p>\n\t</div>\n\t<div class=\"col-sm-4 right_item\">\n\t\t<img class=\"col-sm-12\" src=\"assets/img/me.svg\">\n\t\t<p>个人中心</p>\n\t</div>\n</div>"

/***/ }),

/***/ "./src/app/forum/forum-right-function/forum-right-function.component.ts":
/*!******************************************************************************!*\
  !*** ./src/app/forum/forum-right-function/forum-right-function.component.ts ***!
  \******************************************************************************/
/*! exports provided: ForumRightFunctionComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumRightFunctionComponent", function() { return ForumRightFunctionComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ForumRightFunctionComponent = /** @class */ (function () {
    function ForumRightFunctionComponent(router) {
        this.router = router;
    }
    ForumRightFunctionComponent.prototype.ngOnInit = function () {
    };
    ForumRightFunctionComponent.prototype.skip = function (addr) {
        this.router.navigate([addr]);
    };
    ForumRightFunctionComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum-right-function',
            template: __webpack_require__(/*! ./forum-right-function.component.html */ "./src/app/forum/forum-right-function/forum-right-function.component.html"),
            styles: [__webpack_require__(/*! ./forum-right-function.component.css */ "./src/app/forum/forum-right-function/forum-right-function.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], ForumRightFunctionComponent);
    return ForumRightFunctionComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum-routing.module.ts":
/*!***********************************************!*\
  !*** ./src/app/forum/forum-routing.module.ts ***!
  \***********************************************/
/*! exports provided: ForumRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumRoutingModule", function() { return ForumRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _forum_index_forum_index_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./forum-index/forum-index.component */ "./src/app/forum/forum-index/forum-index.component.ts");
/* harmony import */ var _forum_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./forum.component */ "./src/app/forum/forum.component.ts");
/* harmony import */ var _forum_article_forum_article_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./forum-article/forum-article.component */ "./src/app/forum/forum-article/forum-article.component.ts");
/* harmony import */ var _forum_new_forum_new_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./forum-new/forum-new.component */ "./src/app/forum/forum-new/forum-new.component.ts");
/* harmony import */ var _forum_question_forum_question_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./forum-question/forum-question.component */ "./src/app/forum/forum-question/forum-question.component.ts");
/* harmony import */ var _service_auth_guard_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../service/auth-guard.service */ "./src/app/service/auth-guard.service.ts");
/* harmony import */ var _forum_question_detail_forum_question_detail_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./forum-question-detail/forum-question-detail.component */ "./src/app/forum/forum-question-detail/forum-question-detail.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var routes = [
    { path: 'forum', component: _forum_component__WEBPACK_IMPORTED_MODULE_3__["ForumComponent"],
        children: [
            {
                path: "",
                redirectTo: "index",
                pathMatch: 'full'
            },
            {
                path: "index",
                component: _forum_index_forum_index_component__WEBPACK_IMPORTED_MODULE_2__["ForumIndexComponent"]
            },
            {
                path: "article/:id",
                component: _forum_article_forum_article_component__WEBPACK_IMPORTED_MODULE_4__["ForumArticleComponent"]
            },
            {
                path: "new",
                canActivate: [_service_auth_guard_service__WEBPACK_IMPORTED_MODULE_7__["AuthGuardService"]],
                component: _forum_new_forum_new_component__WEBPACK_IMPORTED_MODULE_5__["ForumNewComponent"]
            },
            {
                path: "question",
                canActivate: [_service_auth_guard_service__WEBPACK_IMPORTED_MODULE_7__["AuthGuardService"]],
                component: _forum_question_forum_question_component__WEBPACK_IMPORTED_MODULE_6__["ForumQuestionComponent"]
            },
            {
                path: "questionDetail/:id",
                canActivate: [_service_auth_guard_service__WEBPACK_IMPORTED_MODULE_7__["AuthGuardService"]],
                component: _forum_question_detail_forum_question_detail_component__WEBPACK_IMPORTED_MODULE_8__["ForumQuestionDetailComponent"]
            }
        ]
    }
];
var ForumRoutingModule = /** @class */ (function () {
    function ForumRoutingModule() {
    }
    ForumRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], ForumRoutingModule);
    return ForumRoutingModule;
}());



/***/ }),

/***/ "./src/app/forum/forum.component.css":
/*!*******************************************!*\
  !*** ./src/app/forum/forum.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/forum/forum.component.html":
/*!********************************************!*\
  !*** ./src/app/forum/forum.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>"

/***/ }),

/***/ "./src/app/forum/forum.component.ts":
/*!******************************************!*\
  !*** ./src/app/forum/forum.component.ts ***!
  \******************************************/
/*! exports provided: ForumComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumComponent", function() { return ForumComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ForumComponent = /** @class */ (function () {
    function ForumComponent() {
    }
    ForumComponent.prototype.ngOnInit = function () {
    };
    ForumComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-forum',
            template: __webpack_require__(/*! ./forum.component.html */ "./src/app/forum/forum.component.html"),
            styles: [__webpack_require__(/*! ./forum.component.css */ "./src/app/forum/forum.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ForumComponent);
    return ForumComponent;
}());



/***/ }),

/***/ "./src/app/forum/forum.module.ts":
/*!***************************************!*\
  !*** ./src/app/forum/forum.module.ts ***!
  \***************************************/
/*! exports provided: ForumModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumModule", function() { return ForumModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _service_api_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../service/api.service */ "./src/app/service/api.service.ts");
/* harmony import */ var _forum_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./forum.component */ "./src/app/forum/forum.component.ts");
/* harmony import */ var _forum_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./forum-routing.module */ "./src/app/forum/forum-routing.module.ts");
/* harmony import */ var _forum_index_forum_left_forum_left_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./forum-index/forum-left/forum-left.component */ "./src/app/forum/forum-index/forum-left/forum-left.component.ts");
/* harmony import */ var _forum_index_forum_right_forum_right_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./forum-index/forum-right/forum-right.component */ "./src/app/forum/forum-index/forum-right/forum-right.component.ts");
/* harmony import */ var _forum_index_forum_index_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./forum-index/forum-index.component */ "./src/app/forum/forum-index/forum-index.component.ts");
/* harmony import */ var _forum_article_forum_article_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./forum-article/forum-article.component */ "./src/app/forum/forum-article/forum-article.component.ts");
/* harmony import */ var _forum_right_function_forum_right_function_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./forum-right-function/forum-right-function.component */ "./src/app/forum/forum-right-function/forum-right-function.component.ts");
/* harmony import */ var _forum_new_forum_new_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./forum-new/forum-new.component */ "./src/app/forum/forum-new/forum-new.component.ts");
/* harmony import */ var ngx_quill__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ngx-quill */ "./node_modules/ngx-quill/index.js");
/* harmony import */ var _forum_question_forum_question_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./forum-question/forum-question.component */ "./src/app/forum/forum-question/forum-question.component.ts");
/* harmony import */ var _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./modal-log/modal-log.component */ "./src/app/forum/modal-log/modal-log.component.ts");
/* harmony import */ var _forum_question_detail_forum_question_detail_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./forum-question-detail/forum-question-detail.component */ "./src/app/forum/forum-question-detail/forum-question-detail.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var ForumModule = /** @class */ (function () {
    function ForumModule() {
    }
    ForumModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _forum_index_forum_left_forum_left_component__WEBPACK_IMPORTED_MODULE_6__["ForumLeftComponent"],
                _forum_index_forum_right_forum_right_component__WEBPACK_IMPORTED_MODULE_7__["ForumRightComponent"],
                _forum_index_forum_index_component__WEBPACK_IMPORTED_MODULE_8__["ForumIndexComponent"],
                _forum_article_forum_article_component__WEBPACK_IMPORTED_MODULE_9__["ForumArticleComponent"],
                _forum_right_function_forum_right_function_component__WEBPACK_IMPORTED_MODULE_10__["ForumRightFunctionComponent"],
                _forum_new_forum_new_component__WEBPACK_IMPORTED_MODULE_11__["ForumNewComponent"],
                _forum_question_forum_question_component__WEBPACK_IMPORTED_MODULE_13__["ForumQuestionComponent"],
                _modal_log_modal_log_component__WEBPACK_IMPORTED_MODULE_14__["ModalLogComponent"],
                _forum_question_detail_forum_question_detail_component__WEBPACK_IMPORTED_MODULE_15__["ForumQuestionDetailComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_http__WEBPACK_IMPORTED_MODULE_2__["HttpModule"],
                _forum_routing_module__WEBPACK_IMPORTED_MODULE_5__["ForumRoutingModule"],
                ngx_quill__WEBPACK_IMPORTED_MODULE_12__["QuillModule"]
            ],
            providers: [
                _service_api_service__WEBPACK_IMPORTED_MODULE_3__["ApiService"]
            ],
            bootstrap: [_forum_component__WEBPACK_IMPORTED_MODULE_4__["ForumComponent"]]
        })
    ], ForumModule);
    return ForumModule;
}());



/***/ }),

/***/ "./src/app/forum/modal-log/modal-log.component.css":
/*!*********************************************************!*\
  !*** ./src/app/forum/modal-log/modal-log.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".log{\r\n    position: fixed;\r\n    top: 0;\r\n    left: 0;\r\n    right: 0;\r\n    bottom: 0;\r\n    margin: auto;\r\n    width: 175px;\r\n    height: 50px;\r\n    line-height: 50px;\r\n    background-color: rgba(0, 0, 0, 0.7);\r\n    text-align: center;\r\n    color: #fff;\r\n    border-radius: 5px;\r\n}\r\n\r\n.log_content{\r\n    display: inline-block;\r\n}"

/***/ }),

/***/ "./src/app/forum/modal-log/modal-log.component.html":
/*!**********************************************************!*\
  !*** ./src/app/forum/modal-log/modal-log.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"log animated hidden\">\n\t<div class=\"log_content\">{{msg}}</div>\n</div>"

/***/ }),

/***/ "./src/app/forum/modal-log/modal-log.component.ts":
/*!********************************************************!*\
  !*** ./src/app/forum/modal-log/modal-log.component.ts ***!
  \********************************************************/
/*! exports provided: ModalLogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModalLogComponent", function() { return ModalLogComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ModalLogComponent = /** @class */ (function () {
    function ModalLogComponent() {
    }
    ModalLogComponent.prototype.ngOnInit = function () {
    };
    ModalLogComponent.prototype.show = function (msg, time) {
        this.msg = msg;
        $(".log").removeClass("hidden");
        $(".log").addClass("fadeIn");
        setTimeout(function () {
            $(".log").removeClass("fadeIn");
            $(".log").addClass("hidden");
        }, time);
    };
    ModalLogComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-modal-log',
            template: __webpack_require__(/*! ./modal-log.component.html */ "./src/app/forum/modal-log/modal-log.component.html"),
            styles: [__webpack_require__(/*! ./modal-log.component.css */ "./src/app/forum/modal-log/modal-log.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ModalLogComponent);
    return ModalLogComponent;
}());



/***/ }),

/***/ "./src/app/service/api.service.ts":
/*!****************************************!*\
  !*** ./src/app/service/api.service.ts ***!
  \****************************************/
/*! exports provided: ApiService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ApiService", function() { return ApiService; });
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ng2-cookies/ng2-cookies */ "./node_modules/ng2-cookies/ng2-cookies.js");
/* harmony import */ var ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_1__);


var ApiService = /** @class */ (function () {
    function ApiService() {
        this.uid = this.getCookie("uid");
        this.token = this.getCookie("token") + "==";
        this.authorId = Number(this.getCookie("authorId"));
    }
    ApiService.prototype.getUrl = function () {
        return 'api/v1';
    };
    ApiService.prototype.getHeaders = function () {
        return new _angular_http__WEBPACK_IMPORTED_MODULE_0__["Headers"]({ 'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
            'FromAgent': 'Broswer',
            'sso_id': this.uid,
            'sso_token': this.token
        });
    };
    ApiService.prototype.getCookie = function (name) {
        return ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_1__["Cookie"].get(name);
    };
    ApiService.prototype.setCookie = function (c_name, value) {
        ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_1__["Cookie"].set(c_name, value, null, '/');
    };
    return ApiService;
}());



/***/ }),

/***/ "./src/app/service/auth-guard.service.ts":
/*!***********************************************!*\
  !*** ./src/app/service/auth-guard.service.ts ***!
  \***********************************************/
/*! exports provided: AuthGuardService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuardService", function() { return AuthGuardService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _forum_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./forum.service */ "./src/app/service/forum.service.ts");
/* harmony import */ var ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ng2-cookies/ng2-cookies */ "./node_modules/ng2-cookies/ng2-cookies.js");
/* harmony import */ var ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__);
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AuthGuardService = /** @class */ (function () {
    function AuthGuardService(router, forumService) {
        this.router = router;
        this.forumService = forumService;
    }
    AuthGuardService.prototype.canActivate = function (route, state) {
        var url = state.url;
        return this.checkLogin(url);
    };
    AuthGuardService.prototype.checkLogin = function (url) {
        //已登录
        var uid = ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].get('uid');
        var token = ng2_cookies_ng2_cookies__WEBPACK_IMPORTED_MODULE_3__["Cookie"].get('token');
        if (uid != "" || token != "") {
            var isLogin = this.forumService.login(uid, token);
            if (isLogin) {
                return true;
            }
            //返回true，放行
            return false;
        }
        else {
            window.open("http://localhost/cenocloud/login.html");
        }
        return false;
    };
    AuthGuardService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _forum_service__WEBPACK_IMPORTED_MODULE_2__["ForumService"]])
    ], AuthGuardService);
    return AuthGuardService;
}());



/***/ }),

/***/ "./src/app/service/forum.service.ts":
/*!******************************************!*\
  !*** ./src/app/service/forum.service.ts ***!
  \******************************************/
/*! exports provided: ForumService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumService", function() { return ForumService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/http */ "./node_modules/@angular/http/fesm5/http.js");
/* harmony import */ var _api_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./api.service */ "./src/app/service/api.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ForumService = /** @class */ (function () {
    function ForumService(http, apiService) {
        this.http = http;
        this.apiService = apiService;
        this.verify = "111";
        this.param = function (obj) {
            var query = '';
            var name, value, fullSubName, subName, subValue, innerObj, i;
            for (name in obj) {
                value = obj[name];
                if (value instanceof Array) {
                    for (i = 0; i < value.length; ++i) {
                        subValue = value[i];
                        fullSubName = name + '[' + i + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += this.param(innerObj) + '&';
                    }
                }
                else if (value instanceof Object) {
                    for (subName in value) {
                        subValue = value[subName];
                        fullSubName = name + '[' + subName + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += this.param(innerObj) + '&';
                    }
                }
                else if (value !== undefined && value !== null) {
                    query += encodeURIComponent(name) + '='
                        + encodeURIComponent(value) + '&';
                }
            }
            return query.length ? query.substr(0, query.length - 1) : query;
        };
        this.api_url = apiService.getUrl();
        this.headers = apiService.getHeaders();
        this.uid = apiService.getCookie("uid");
        this.token = apiService.getCookie("token") + "==";
    }
    ForumService.prototype.getauthorId = function () {
        return Number(this.apiService.getCookie("authorId"));
    };
    ForumService.prototype.login = function (uid, token) {
        var url = "https://api.sso.cenocloud.com/login/" + uid + "/" + token + "/auth";
        return this.http.get(url, { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.joinForum = function (uid, token) {
        var top = this;
        var url = "" + this.api_url + "/author/me";
        return this.http.post(url, this.param({}), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.addName = function (name, uid, token) {
        var data = {
            nickname: name
        };
        var url = "" + this.api_url + "/author/me/init";
        return this.http.post(url, this.param(data), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.getForumIndexLeft = function () {
        var url = "" + this.api_url + '/article/all/0/100/list';
        return this.http.post(url, { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.getForumArticle = function (id) {
        var url = "" + this.api_url + '/article/detail/' + id;
        return this.http.post(url, { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.publishNew = function (data) {
        data.authorId = this.getauthorId();
        var url = "" + this.api_url + "/article/" + this.verify + "/pub";
        return this.http.post(url, this.param(data), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.publishQuestion = function (data) {
        data.authorId = this.getauthorId();
        var url = "" + this.api_url + "/question/" + this.verify + "/ask";
        return this.http.post(url, this.param(data), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.getQuestionList = function (page) {
        var num = 8;
        var url = "" + this.api_url + "/question/all/" + page + "/" + num + "/list";
        return this.http.post(url, { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.publishComment = function (data) {
        var url = "" + this.api_url + "/article/" + this.verify + "/comment";
        console.log(this.param(data));
        return this.http.post(url, this.param(data), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.getComment = function (id, page, num) {
        var url = "" + this.api_url + "/article/" + id + "/" + page + "/" + num + "/listComment";
        return this.http.post(url, this.param({}), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.Star = function (id) {
        var url = "" + this.api_url + "/comment/" + id + "/star";
        return this.http.post(url, this.param({}), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res;
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.QuestionDetail = function (id) {
        var url = "" + this.api_url + "/question/" + id + "/get";
        return this.http.post(url, this.param({}), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.publishAnswer = function (data) {
        var url = "" + this.api_url + "/question/" + this.verify + "/answer";
        return this.http.post(url, this.param(data), { headers: this.headers })
            .toPromise()
            .then(function (res) {
            var data = res.json();
            console.log(data);
            return data;
        })
            .catch(this.handleError);
    };
    ForumService.prototype.handleError = function (error) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    };
    ForumService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_http__WEBPACK_IMPORTED_MODULE_1__["Http"], _api_service__WEBPACK_IMPORTED_MODULE_2__["ApiService"]])
    ], ForumService);
    return ForumService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! G:\forum\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map