<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <style type="text/css">
        @page{size:397mm 280mm;}//纸张大小


            /*公示系统css文件*/

            /*css reset*/
        html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, caption, select, option {
            margin: 0;
            padding: 0;
            border: 0;
            outline: 0;
            font-weight: inherit;
            font-style: inherit;
            font-family: inherit;
            vertical-align: baseline;
        }

        body {

            font-size: 14px;
        }
        body {
            margin-left: 0px;
            margin-right: 0px;
            font-family: Arial Unicode MS;
            font-size: 10px;
        }

        ol, ul {
            list-style: none
        }

        table {
            border-collapse: collapse;
        }

        caption, th, td {
            font-weight: normal
        }

        blockquote:before, blockquote:after, q:before, q:after {
            content: ''
        }

        blockquote, q {
            quotes: "" ""
        }

        input:-webkit-autofill, textarea:-webkit-autofill, select:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px white inset;
        }

        input {
            vertical-align: middle;
            border: none;
            outline: none;
            padding: 0;
        }

        textarea {
            outline: none;
        }

        img {
            border: none 0;
            vertical-align: middle;
            outline: none;
        }

        strong {
            font-weight: bold;
        }

        .ml10 {
            margin-left: 10px;
        }

        .mr20 {
            margin-right: 20px;
        }

        .tr {
            text-align: right;
        }
        .va-top {
            vertical-align: top;
        }
        .gt_holder.popup .gt_mask {
            z-index: 2;
        }

        .state-msg em.bdnone {
            border-right: none;
        }

        .dib {
            display: inline-block;
        }

        .a-orange {
            color: #ffb66c;
        }

        /* 清除浮动*/
        .clearfix:after {
            content: " ";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden;
            font-size: 0;
            line-height: 0;
        }

        *.clearfix {
            zoom: 1;
        }

        .center {
            text-align: center !important;
        }

        .left {
            text-align: left !important;
        }

        .right {
            text-align: right !important;
        }

        /* 浮动*/
        .fl {
            float: left;
        }

        .fr {
            float: right;
        }

        /* 相对定位*/
        .pos-rel {
            position: relative;
        }

        /*超链接*/
        a {
            text-decoration: none;
        }

        /* 留白*/
        .ml5 {
            margin-left: 5px
        }

        .ml120 {
            margin-left: 120px;
        }

        .ml320 {
            margin-left: 500px;
        }

        .ml20 {
            margin-left: 20px;
        }

        .ml50 {
            margin-left: 50px;
        }

        .mt20 {
            margin-top: 20px !important;
        }

        .mb20 {
            margin-bottom: 20px;
        }

        .mb36 {
            margin-bottom: 36px;
        }

        .mt33 {
            margin-top: 33px;
        }

        .mr5 {
            margin-right: 5px;
        }

        /* display*/
        .none {
            display: none;
        }

        .font-14 {
            font-size: 14px !important;
        }

        /*边距*/
        .pb10 li {
            padding-bottom: 10px;
        }

        .pdb6 {
            padding-bottom: 6px;
        }

        .pdb160 {
            padding-bottom: 160px;
        }

        .plr20 {
            padding-left: 20px;
            padding-right: 20px;
        }


        /*模块对齐*/
        .mod {
            margin: 0 auto;
            /*width: 1000px;*/
            width: 1120px;
            position: relative;
        }

        .mod1366 {
            margin: 0 auto;
            width: 1366px;
            position: relative;
        }

        .tr-center {
            text-align: center !important;
        }

        /*背景颜色*/
        .outer-blue-bg {
            background-color: #084C8B;
        }

        .footer-box {
            background-color: #fff;
            border-top: 1px solid #d5d5d5;
        }

        /*边框*/
        .border-top9 {
            border-top: 9px solid #ab812d;
        }

        .border-top7 {
            border-top: 7px solid #ab812d;
        }

        .border-bottom {
            border-bottom: 1px solid #d5d5d5;
        }

        /*页面尾部*/
        .footer {
            font: normal 12px/20px "Microsoft Yahei";
            color: #8F8F8F;
            padding: 14px 0 16px 0;
            text-align: center;
        }

        .footer span {
            display: inline-block;
            padding: 0 12px;
        }

        .footer a {
            color: red;
        }

        .footer a:hover {
            color: blue;
        }

        /*搜索页面*/
        .outer-blue-bg {
            background-color: #ab812d;
        }

        .header-se h2 {
            color: #fffffd;
            position: relative;
            padding-top:14px;
            padding-bottom: 12px;
            font-size: 0px;
        }

        .area-select {
            position: absolute;
            right: 95px;
            bottom: 25px;
            color: #999;
            font-size: 12px;
            line-height: 24px;
            background: url("../img/pub/locate-icon.png") no-repeat -7px 0px;
            padding-left: 20px;
        }

        .search-style {
            top: 17px;
            right: 0;
            font-size: 14px;
            color: #fff;
            background: none;
        }

        .area-select .pull-down-icon {
            display: inline-block;
            width: 26px;
            height: 19px;
            background: url("../img/pub/pull-down-icon.png") no-repeat -2px 2px;
        }

        .inner-area-select {
            position: absolute;
            top: 19px;
            right: 57px;
            font-size: 14px;
            color: #fff;
        }

        .local-pd {
            position: absolute;
            right: 33px;
            bottom: 25px;
            font-size: 12px;
            color: #999;
            line-height: 24px;
            padding-left: 20px;
            background: url("../img/pub/collect-icon.png") no-repeat 0 5px;
        }

        .area-box {
            position: absolute;
            width: 354px;
            height: 245px;
            right: 100px;
            bottom: -242px;
            color: #333;
            border: 1px solid #ab812d;
            background-color: #fff;
            padding-top: 20px;
            padding-left: 30px;
            z-index: 99999;
            display: none;
        }

        .area-box p {
            font: normal 14px/14px "Microsoft Yahei";
            margin-bottom: 16px;
        }

        .area-box p span {
            display: inline-block;
            padding-right: 12px;
            border-right: 1px solid #7c7c7c;
            color: #996726;
            font-weight: 700;
        }

        .area-box p a {
            display: inline-block;
            padding-left: 12px;
            color: #333;
        }

        .search-box-style {
            right: 0;
            top: 52px;
        }

        .search-cont {
            width: 692px;
            position: absolute;
            left: 50%;
            top: 158px;
            margin-left: -349px;
        }

        .select-tab {
            padding: 15px 0 15px 40px;
        }

        .select-tab a {
            display: inline-block;
            padding: 0 38px 0 20px;
            font-size: 14px;
            line-height: 14px;
            position: relative;
            color: #333;
        }

        .select-tab a.select {
            color: #333;
            background: url("../img/pub/trangle.png") no-repeat 0 3px;
            font-weight: bold;
        }

        .select-tab a:first-child:before {
            display: none;
        }

        .select-tab a.select {

        }

        .index-banner-bg {
            background: url("../img/pub/index-banner.jpg") no-repeat center bottom;
        }

        .se-banner-bg {
            min-height: 240px;
            position: relative;
        }

        .search-do {
            width: 692px;
            height: 60px;
            background: url("../img/pub/search-box.jpg") no-repeat left top;
            position: relative;
        }

        .search-do .se-box {
            position: absolute;
            font-size: 12px;
            line-height: 38px;
            top: 13px;
            left: 45px;
            width: 480px;
            z-index: 1;
            height: 38px;
        }

        .search-do .se-btn {
            position: absolute;
            top: 0;
            right: 0;
            width: 137px;
            height: 60px;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer;
            z-index: 1;
        }

        .se-other-bg {
            background: url("../img/pub/se-other-navbg.jpg") repeat-x left top;
        }

        .se-other-nav ul {
            padding: 122px 186px 100px;
        }

        .se-other-nav li {
            float: left;
            /*width: 148px;*/
            width: 186px;
            height: 80px;
        }

        .se-other-nav li em{
            display: block;
            width: 80px;
            height: 80px;
            margin: 0 auto;
            box-sizing: border-box;
            text-align: center;
            background: url("../img/pub/se-icon-bg.png") no-repeat center 0;
        }

        .se-other-nav a:hover em {
            background: url("../img/pub/se-icon-bg-h.png") no-repeat center 0;
        }

        .se-other-nav li i {
            display: block;
            height: 80px;
        }

        .se-other-nav li span {
            display: block;
            line-height: 38px;
            font-size: 16px;
            color: #333;
            text-align: center;
        }

        .se-compinfo {
            background: url("../img/pub/se-compinfo.png") no-repeat 21px 17px;
        }

        .gs-info {
            background: url("../img/pub/se-gsinfo.png") no-repeat 19px 21px;
        }

        .part-app {
            background: url("../img/pub/se-setinfo.png") no-repeat 19px 19px;
        }

        .use-help {
            background: url("../img/pub/se-useinfo.png") no-repeat 19px 21px;
        }

        .xwqy-info {
            background: url("../img/pub/se-xwinfo.png") no-repeat 19px 24px;
        }

        /*.se-other-nav a:hover .se-compinfo {*/
        /*background: url("../img/pub/se-compinfo-h.png") no-repeat 21px 17px #6eafd9;*/
        /*}*/

        /*.se-other-nav a:hover .gs-info {*/
        /*background: url("../img/pub/se-gsinfo-h.png") no-repeat 19px 21px #6eafd9;*/
        /*}*/

        /*.se-other-nav a:hover .xwqy-info {*/
        /*background: url("../img/pub/se-xwinfo-h.png") no-repeat 19px 24px #6eafd9;*/
        /*}*/

        /*.se-other-nav a:hover .use-help {*/
        /*background: url("../img/pub/se-useinfo-h.png") no-repeat 19px 21px #6eafd9;*/
        /*}*/

        /*.se-other-nav a:hover .part-app {*/
        /*background: url("../img/pub/se-setinfo-h.png") no-repeat 19px 19px #6eafd9;*/
        /*}*/

        /*infoNotice start*/

        .sidebar {
            /*width: 200px;*/
            width: 214px;
            float: left;
            font-size: 14px;
        }

        .navbar > li > a {
            background: #ab812d;
            height: 38px;
            line-height: 38px;
            display: block;
            color: #fff;
        }

        .navbar > li:first-child > a {
            border-radius: 5px 5px 0 0;
        }

        .navbar > li a.selected {
            background: #af1d1d;
        }

        .navbar > li > a > i {
            display: inline-block;
            width: 21px;
            height: 20px;
            background: #ccc;
            vertical-align: top;
            margin-top: 10px;
            margin-right: 10px;
            margin-left: 20px;
        }

        .navbar > li > a > i.icon-news {
            background: url(/img/pub/icon-news.png);
        }

        .navbar > li > a > i.icon-dynamic {
            background: url(/img/pub/icon-dynamic.png);
        }

        .navbar > li > a > i.icon-anomaly {
            background: url(/img/pub/icon-anomaly.png);
        }

        .navbar > li > a > i.icon-bulletin {
            background: url(/img/pub/icon-bulletin.png);
        }

        .navbar > li > a > i.icon-spotcheck {
            background: url(/img/pub/icon-spotcheck.png);
        }

        .navbar > li > a > i.icon-punishment {
            background: url(/img/pub/icon-punishment.png);
        }

        .navbar > li > a > i.icon-justice {
            background: url(/img/pub/icon-justice.png);
        }

        .navbar > li > a > i.icon-simpcan {
        }

        .navbar > li > a > i.icon-illdisout {
        }

        .navbar > li > a > i.icon-inspect {
        }

        .navbar > li > a > i.icon-other {
        }

        .subnavbar {
            /*border-top: 1px solid #d1d1d1;*/
        }

        .subnavbar > li {
            background: url(../img/pub/subnavbar_bg.png) repeat-x;
            text-indent: 50px;
        }

        .subnavbar > li > a {
            background: #f2e8d5 url(/img/pub/subnavbar-li.png) no-repeat 28px 12px;
            height: 36px;
            line-height: 36px;
            border: 1px solid #cccccc;
            border-top: 0;
            display: block;
            color: #666;
        }

        .subnavbar > li > a.selected {
            background: #af1d1d url(/img/pub/subnavbar-li-selected.png) no-repeat 28px 12px;
            color: #fff;
        }

        .notice-cont {
            /*margin-left: 20px;*/
            margin-left: 10px;
            width: 895px;
        }

        .border-box {
            border: 1px solid #d1d1d1;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
        }

        .notice-list-box {
            margin-bottom: 10px;
        }

        .notice-query .i-title > i {
            background-color: #cfab5f;
        }

        .i-title {
            font-size: 16px;
        }

        .i-title > i {
            display: inline-block;
            width: 6px;
            height: 14px;
            background-color: #804000;
            margin-right: 10px;
            vertical-align: -2px;
        }

        .query-title {
            margin-bottom: 20px;
        }

        .query-area {
            margin-bottom: 15px;
        }

        .query-title .i-title {
            margin-top: 9px;
        }

        .notice-query {
            color: #211716;
            background-color: #fff;
        }

        .notice-search, .notice-area {
            margin-left: 100px;
        }

        .notice-search .ipt-search-wrap {
            background: url(../img/pub/notice-search-bg.png) no-repeat;
            width: 458px;
            height: 40px;
            position: relative;
        }

        .notice-search .ipt-search-wrap input {
            position: absolute;
            width: 448px;
            height: 32px;
            line-height: 32px;
            left: 8px;
            top: 5px;
        }

        .notice-search .search-btn {
            width: 94px;
            height: 40px;
            display: block;
            background: url(../img/pub/notice-search-btn.png) no-repeat;
            margin-left: 15px;
        }

        .notice-area span {
            display: inline-block;
            width: 70px;
        }

        .w80 {
            width: 80px !important;
        }

        .notice-area a {
            display: inline-block;
            font-size: 14px;
            padding: 2px 4px;
            color: #515151;
            margin-bottom: 6px;
        }

        .notice-area a.selected {
            background-color: #cfa95e;
            color: #fff;
            border-radius: 3px;
        }

        .border-title {
            font-size: 16px;
            font-weight: bold;
            border-bottom: 2px solid #d1ab62;
            padding-bottom: 10px;
        }

        .border-title .more {
            font-size: 14px;
            font-weight: 400;
            color: #2668A5;
        }

        .icon1 {
            display: inline-block;
            width: 22px;
            height: 22px;
            background: url(../img/pub/icon-notice.png) no-repeat;
            vertical-align: top;
            margin: 2px 8px 0 0;
        }

        .notice-list {
            margin-top: 15px;
        }

        .notice-list li {
            background: url(../img/pub/notice-li-type.png) no-repeat 0 7px;
            font-size: 14px;
            text-indent: 14px;
            height: 24px;
            line-height: 24px;
            margin-bottom: 20px;
        }

        .notice-list li a {
            color: #434343;
            width: 483px;
            height: 24px;
            line-height: 24px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        .notice-list li a:hover {
            color: #1559c8;
            text-decoration: underline;
        }

        .notice-list li .time {
            float: right;
            font-size: 12px;
            color: #b2b2b2;
        }

        .header-se.header-notice h2 {
            padding: 40px 0;
        }

        .notice-nav-box {
            margin-bottom: 20px;
            background: url(../img/pub/notice-nav-bg.png) repeat-x;
            height: 50px;
        }

        .notice-nav li {
            float: left;
            height: 50px;
            line-height: 50px;
            font-size: 16px;
            width: 200px;
            text-align: center;
            position: relative;
            background: url(../img/pub/notice-nav-bod.png) no-repeat right 0;
        }

        .notice-nav li:last-child {
            background: none;
        }

        .notice-nav li.selected {
            margin-left: -2px;
            background: url(../img/pub/notice-nav-curbg.png) no-repeat;
        }

        .notice-nav li a {
            display: block;
            color: #fff;
        }

        .notice-nav li a > i {
            display: inline-block;
            width: 24px;
            height: 18px;
            background: #ccc;
            vertical-align: top;
            margin-top: 16px;
            margin-right: 5px;
        }

        .notice-nav li a > i.icon-index {
        }

        .notice-nav li a > i.icon-qy {
        }

        .notice-nav li a > i.icon-xw {
        }

        .notice-nav li a > i.icon-help {
        }

        .page-total {
            font-size: 12px;
            line-height: 30px;
            margin-right: 10px;
        }

        /*infoNotice end*/
        /*noticeHelp start*/
        .mod-hd {
            background-color: #d1a961;
            height: 40px;
            /*border-bottom: 1px solid #084c8b;*/
        }

        .mod-hd h3 {
            color: #996726;
            display: inline-block;
            /*border: 1px solid #084c8b;*/
            background-color: #fff;
            border-bottom: 0;
            padding: 7px 25px;
            margin-top: 8px;
            margin-left: 20px;
            /*border-radius: 5px 5px 0 0;*/
        }

        .mod-help {
            background-color: #fff;
        }

        .mode-help-bd {
            padding: 0 20px 50px;
        }

        .mode-help-bd h1 {
            text-align: center;
            margin-top: 60px;
            font-weight: bold;
        }

        .mode-help-bd h3 {
            font-weight: bold;
            margin-top: 40px;
            margin-bottom: 10px;
            color: #996726;
        }

        .mode-help-bd > p {
            line-height: 30px;
            text-indent: 24px;
        }

        /*noticeHelp end*/

        /*noticeDetail start*/
        .mod-notice-detail {
            background-color: #fff;
        }

        .mod-notice-detail2 .mod-notice-bd {
            padding: 0 50px;
            font-size: 16px !important;
            color: #333;
            line-height: 36px;
        }

        .mod-notice-bd {
            padding: 0 30px;
        }

        .mod-notice-bd h1 {
            text-align: center;
            margin: 50px 0 5px;
            font-weight: bold;
            font-size: 28px;
            line-height: 36px;
        }

        .mod-notice-bd > p {
            line-height: 36px;
            text-indent: 24px;
        }

        .mod-notice-fd {
            padding: 150px 50px 80px;
            text-align: right;
            line-height: 30px;
            font-size: 16px;
        }

        .mod-notice-detail .encounter-info {
            margin-left: 40px;
            margin-bottom: -10px;
            padding-top: 10px;
        }

        .mod-notice-detail .encounter-info li {
            list-style: initial;
        }

        .mod-notice-detail .pdf-text {
            height: 130px;
            background: #fff;
            border: 1px solid #efefef;
            line-height: 130px;
            text-align: center;
            color: #666;
        }

        .mod-notice-detail .mod-bd-panel_company {
            background-color: #fff;
        }

        .table-horizontal td {
            border: 1px solid #edeeee;
            padding: 10px 5px;
            color: #666;
        }

        .table-horizontal td:nth-child(2n+1) {
            background-color: #eae3db;
            font-weight: bold;
            text-align: right;
            color: #87550F;
        }

        .table-horizontal tr:nth-child(2n) td:nth-child(2n) {
            background-color: #f7f8fa;
        }

        .table-horizontal2 {
            background-color: #f7f8fa;
        }

        .table-horizontal2 td {
            border: 1px solid #edeeee;
            padding: 7px 0;
            color: #666;
            padding-right: 12px;
        }

        .table-horizontal2 td input, .table-horizontal2 td select {
            border: 1px solid #a9a9a9;
            width: 356px;
            height: 23px;
            line-height: 23px;
            margin-left: 60px;
        }

        .table-horizontal3 td input, .table-horizontal3 td select {
            margin-left: 50px;
        }

        .bg-brown {
            background-color: #eae3db;
            color: #87550F !important;
            font-weight: 700;
        }

        /*noticeDetail end*/

        /* entsearch_list */
        .enterprise-info-bg {
            background: rgba(251, 248, 239, 1);
        }

        .info-tb-gray {
            background-color: rgba(247, 247, 247, 1);
        }

        .enterprise-info-header {
            height: 52px;
        }

        .enterprise-info-nav {
            width: 781px;
            overflow: hidden;
            border-left: 1px solid #d1ab62;
            border-right: 1px solid #7f5910;
        }

        .enterprise-info-nav li {
            float: left;
            line-height: 52px;
            border-left: 1px solid #7f5910;
            border-right: 1px solid #d1ab62;
            padding: 0 46px;
        }

        .enterprise-info-nav .bdrnone {
            border-right: none;
        }

        .enterprise-info-nav .bdlnone {
            border-left: none;
        }

        .enterprise-info-nav li a {
            font-size: 18px;
            color: #fff;
        }

        .enterprise-info-nav i {
            display: inline-block;
            width: 22px;
            height: 26px;
            margin-right: 6px;
            vertical-align: -8px;
        }

        .enterprise-info-nav .icon-home {
            width: 25px;
            background: url(/img/pub/home-icon.jpg) no-repeat;
            vertical-align: -11px;
        }

        .enterprise-info-nav .icon-reported {
            background: url(/img/pub/companyinfo_icon.png) no-repeat;
            background-size: 22px;
        }

        .enterprise-info-nav .icon-notice {
            background: url(/img/pub/inforbulletin_icon.png) no-repeat;
            background-size: 20px;
        }

        .enterprise-info-nav .icon-help {
            width: 24px;
            background: url(/img/pub/help_icon.png) no-repeat;
            background-size: 24px;
        }

        .enterprise-info-search {
            /*padding: 2px 0 15px;*/
            padding: 0 0 12px;
        }

        .enterprise-info-search .logo {
            float: left;
            display: inline;
            margin-top: 12px;
        }

        .enterprise-info-search .logo a {
            display: block;
            width: 598px;
            height: 71px;
            background: url(../img/pub/logo.png) no-repeat;
        }

        .enterprise-info-search .search-content {
            float: left;
            margin-top: 6px;
            margin-left: 60px;
        }

        .enterprise-info-search .search-content .select-tab {
            margin-right: -12px;
            padding: 2px 0;
        }

        .enterprise-info-search .select-tab a {
            padding: 0 10px 0 9px;
            line-height: 26px;
            font-size: 14px;
        }

        .enterprise-info-search .select-tab a:hover,
        .enterprise-info-search .select-tab a.select {
            text-decoration: underline;
            background: none;
            color: rgb(153, 103, 38);
            font-weight: normal;
        }

        .enterprise-info-search .search-do {
            width: 401px;
            height: 36px;
            background: url("../img/pub/se-input-bg2.jpg");
        }

        .enterprise-info-search .search-do .se-box {
            line-height: 22px;
            top: 7px;
            width: 350px;
            position: absolute;
            left: 5px;
            background: transparent;
            height: 22px;
        }

        .enterprise-info-search .search-do .se-btn {
            width: 40px;
            height: 36px;
            cursor: pointer;
        }

        .enterprise-info-search .select-tab a:first-child {
            margin-left: -14px;
        }

        .enterprise-info .title {
            color: #6c6c6c;
            font-size: 14px;
            line-height: 45px;
            border-bottom: 1px dashed #d2ab60;
        }

        .enterprise-info .title .light {
            color: #eb5857;
        }

        .enterprise-info-list li {
            padding: 10px 6px 18px;
            margin-bottom: 8px;
            border-bottom: 1px solid #e8d4af;
        }

        .enterprise-info-list li a {
            font-size: 18px;
            line-height: 40px;
            font-weight: bold;
            color: #333;
        }

        .light {
            color: #f92220;
            cursor: pointer;
        }

        .enterprise-info-list li .tip {
            color: #eb5857;
            font-weight: normal;
            font-size: 14px;
        }

        .enterprise-info-search .select-tab .search-icon {
            float: left;
            margin-top: 7px;
            background: url(/img/pub/icon-search.jpg) no-repeat;
            width: 16px;
            height: 15px;
        }

        .enterprise-info-search .select-tab .tab-line {
            display: inline-block;
            width: 1px;
            height: 11px;
            background: #d7d7d7;
        }

        .enterprise-info-search .select-tab .item-first:before {
            border-left: none;
        }

        .enterprise-info-list li .item-text {
            margin-right: -100px;
        }

        .enterprise-info-list .icon-rectangle {
            margin: 0 2px 0 6px;
        }

        .enterprise-info-list .item-text span {
            display: inline-block;
            color: #6c6c6c;
        }

        .enterprise-info-list .item-text .code {
            width: 380px;
        }

        .enterprise-info-list .item-text .person {
            min-width: 270px;
            margin-right: 30px;
        }

        .enterprise-info-list .item-text i {
            display: inline-block;
            margin-right: 4px;
            width: 15px;
            height: 15px;
            vertical-align: -3px;
        }

        .book-icon {
            background: url(/img/pub/book_icon.png) no-repeat;
        }

        .book2-icon {
            background: url(/img/pub/book2_icon.png) no-repeat;
        }

        .person-icon {
            background: url(/img/pub/person_icon.png) no-repeat;
        }

        .person2-icon {
            background: url(/img/pub/person2-icon.png) no-repeat;
        }

        .date-icon {
            background: url(/img/pub/date_icon.png) no-repeat;
        }

        .date2-icon {
            background: url(/img/pub/date2_icon.png) no-repeat;
        }

        .local-icon {
            background: url(/img/pub/local_icon.png) no-repeat;
        }

        .icon-rectangle {
            display: inline-block;
            width: 43px;
            height: 22px;
            line-height: 22px;
            font-size: 12px;
            vertical-align: 3px;
            color: #fff;
            text-align: center;
            font-style: normal;
            border-radius: 3px;
            margin-top: 6px;
        }

        .icon-rectangle.icon-blue {
            background: #4395e1;
        }

        .icon-rectangle.icon-red {
            background: #f92220;
        }

        .icon-rectangle.icon-gray {
            background: #666;
        }

        .icon-rectangle.icon-darkblue {
            background: #016dcf;
        }

        .outer-white-bg {
            background: #fff;
            border-bottom: 1px solid #efefef;
        }

        .notice-info-top .outer-white-bg {
            background: #fff url(/img/pub/notice-header-bg.png) no-repeat right 0;
        }

        .icon-search {
            display: inline-block;
            margin-right: -6px;
            width: 16px;
            height: 15px;
            vertical-align: -4px;
            background: url("../img/pub/icon-search.jpg");
        }

        /* 翻页 */
        .notice-pagination-box {
            text-align: center;
        }

        .notice-pagination-box .pagination {
            display: inline-block;
            margin-right: 0;
        }

        .notice-pagination-box .pagination a, .notice-pagination-box .pagination span {
            padding: 3px 9px;
            border: 1px solid #ecddbe;
            margin-right: 5px;
        }

        .notice-pagination-box .pagination a {
            color: #d0ab5d;
        }

        .pagination-box {
            padding: 24px 0;
        }

        .pagination {
            text-align: center;
        }

        .pagination a {
            text-decoration: none;
            border: 1px solid #AAE;
            color: #15B;
        }

        .pagination a, .pagination span, .notice-pagination-box .pagination a, .notice-pagination-box .pagination span {
            display: inline-block;
            padding: 3px 8px;
            margin-right: 5px;
            border: 1px solid #ecddbe;
            line-height: 1.42857143;
            color: #d0ab5d;
            font-size: 12px;
            background: #fff;
        }

        .pagination a:hover, .pagination span:hover {
            color: #fff;
            background: #d2aa64;
        }

        .pagination a.current,
        .pagination span.current {
            color: #fff;
            background: #d2aa64;
        }

        .pagination a.current.prev,
        .pagination a.current.next {
            color: #d0ab5d;
            background: #fff;
        }

        .notice-pagination-box .pagination .current.prev,
        .notice-pagination-box .pagination .current.next {
            color: #d0ab5d;
            border-color: #ecddbe;
            background: #fff;
            padding: 3px 8px;
        }

        .notice-pagination-box .pagination a:hover {
            color: #fff;
            background-color: #d2aa64;
            border: 1px solid #d2aa64;
        }

        .current.prev, .current.next {
            cursor: not-allowed;
        }

        .pagination .icon-triangle-left,
        .pagination .current.prev:hover .icon-triangle-left {
            display: inline-block;
            margin-right: 3px;
            width: 0;
            height: 0;
            border-top: 5px solid transparent;
            border-right: 5px solid #d2aa64;
            border-bottom: 5px solid transparent;
        }

        .pagination .icon-triangle-right,
        .pagination .current.next:hover .icon-triangle-right {
            display: inline-block;
            margin-left: 3px;
            width: 0;
            height: 0;
            border-top: 5px solid transparent;
            border-left: 5px solid #d2aa64;
            border-bottom: 5px solid transparent;
        }

        .pagination a:hover .icon-triangle-left {
            border-top: 5px solid transparent;
            border-right: 5px solid #fff;
            border-bottom: 5px solid transparent;
        }

        .pagination a:hover .icon-triangle-right {
            border-top: 5px solid transparent;
            border-left: 5px solid #fff;
            border-bottom: 5px solid transparent;
        }

        .pagination .prev,
        .pagination .prev + a,
        .pagination .next {
            margin-right: 5px;
        }

        .company-basic {
            margin-top: 20px;
            margin-bottom: 20px;
            padding: 24px 46px;
            min-height: 194px;
            background: #fff;
            box-sizing: border-box;
            border: 1px solid #ccc;
            box-shadow: 3px 3px 2px 0 #c6c3bc;
            -ms-box-shadow: 3px 3px 2px 0 #c6c3bc;
            -webkit-box-shadow: 3px 3px 2px 0 #c6c3bc;
            -moz-box-shadow: 3px 3px 2px 0 #c6c3bc;
        }

        .company-basic .caption .title {
            position: relative;
            font-size: 24px;
            font-weight: bold;
            color: #4e4e4e;
            margin-bottom: 6px;
        }

        .company-basic .caption .tip {
            display: inline-block;
            vertical-align: 3px;
            padding: 0 4px;
            color: #fff;
            font-weight: normal;
            font-size: 14px;
            line-height: 24px;
            border-radius: 2px;
            background: #eb5857;
            cursor: pointer;
        }

        .company-basic .caption p {
            font-size: 14px;
            line-height: 24px;
            color: #545454;
            font-weight: bold;
        }

        .company-basic .caption p span {
            color: #4c9be4;
            font-weight: 100;
        }

        .company-basic .caption i {
            display: inline-block;
            margin-right: 6px;
            width: 16px;
            height: 16px;
            vertical-align: -4px;
        }

        .company-basic .btn-box {
            position: absolute;
            top: 24px;
            right: 44px;
        }

        .company-basic .btn-box a {
            display: block;
            margin-bottom: 10px;
            width: 140px;
            height: 34px;
            line-height: 34px;
            color: #fff;
            text-indent: 12px;
            background: #cb9f4f;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
        }

        .company-basic .btn-box a.light-blue-bg {
            background-color: #996726;
        }

        .company-basic .btn-box a.green-bg {
            background-color: #634A1D;
        }

        .company-basic .btn-box i {
            display: inline-block;
            margin-right: 14px;
            width: 30px;
            height: 26px;
            vertical-align: -6px;
        }

        .send-icon {
            background: url(/img/pub/send_icon.png) no-repeat;
        }

        .share-icon {
            background: url(/img/pub/share_icon.png) no-repeat;
        }

        .print-icon {
            background: url(/img/pub/print_icon.png) no-repeat 2px top;
            vertical-align: -10px !important;
        }

        .company-tab .tab-list {
            height: 40px;
            padding-left: 18px;
            background: #084c8b;
        }

        .company-tab .tab-list li {
            float: left;
            margin-right: 6px;
            margin-top: 4px;
        }

        .company-tab .tab-list li a {
            display: inline-block;
            padding: 0 20px;
            height: 36px;
            line-height: 36px;
            color: #fff;
            font-size: 16px;
        }

        .company-tab .tab-list li a:hover,
        .company-tab .tab-list li .current {
            color: #084c8b;
            background: #fff;
            -webkit-border-radius: 3px 3px 0 0;
            -moz-border-radius: 3px 3px 0 0;
            border-radius: 3px 3px 0 0;
        }

        .mod-bd-panel_company {
            padding: 0 24px 24px;
            border-right: 1px solid #f0f0f0;
            border-left: 1px solid #f0f0f0;
            border-bottom: 1px solid #f0f0f0;
        }

        .mod-bd-panel_company .tip {
            margin-left: 56px;
            font-size: 12px;
            color: #f92220;
            text-align: center;
            line-height: 30px;
            vertical-align: 1px;
        }

        .mod-bd-panel_company .i-title {
            padding-top: 20px;
            margin-bottom: 12px;
            color: #804000;
        }

        .mod-bd-panel_company .title-bordertop {
            border-top: 1px solid #f0f0f0;
        }

        .mod-bd-panel_company .more {
            float: right;
            font-size: 12px;
            color: #ff8204;
        }

        .mod-bd-panel_company .number {
            float: right;
            margin-right: 20px;
            font-size: 14px;
            color: #333;
        }

        .mod-bd-panel_company.pt10 {
            padding-top: 10px;
        }

        .explain-txt {
            z-index: 1;
            width: 1110px;
            font-size: 16px;
            line-height: 40px;
            color: #fff;
            text-align: center;
            background-color: #ca9a37;
        }

        .encounter-info {
            margin-bottom: -16px;
        }

        .encounter-info li {
            margin-bottom: 16px;
            float: left;
            width: 50%;
            line-height: 20px;
            min-height: 20px;
        }

        .encounter-info li em {
            margin-right: 5px;
        }

        .encounter-info li .title {
            padding-right: 0;
            color: #545454;
            font-weight: bold;
        }

        .encounter-info li .title.light {
            color: #f92220;
        }

        .encounter-info li span {
            color: #555;
            vertical-align: top;
        }

        .encounter-info .brand-item b {
            display: block;
            font-weight: normal;

        }

        .encounter-info .item-width {
            width: 100%;
        }

        .table-common {
            width: 100%;
            border-top: solid 1px #f0f0f0;
            border-left: solid 1px #f0f0f0;
        }

        .table-common .title {
            color: #9b7d46;
            text-align: center;
            background: #eae3db;
        }

        .table-common th {
            height: 33px;
            font-weight: 700;
            color: #9b7d46;
            border-right: solid 1px #f0f0f0;
            border-bottom: solid 1px #f0f0f0;
            background: #eae3db;
        }

        .table-common th td {
            padding: 7px 0;
            color: #9b7d46;
        }

        .table-common td {
            height: 40px;
            text-align: center;
            color: #666;
            word-break: break-all;
            border-right: solid 1px #f0f0f0;
            border-bottom: solid 1px #f0f0f0;
        }

        .table-common td.col-l {
            text-align: left;
            padding-left: 10px;
        }

        .table-common td.col-r {
            text-align: right;
        }

        .table-common td a {
            color: #ffb66c;
        }

        .table-common .left {
            text-align: left;
        }

        .table-common .right {
            text-align: right;
        }

        .table-common.table-justicedetail .col-r {
            color: #0B4C8C;
            padding-right: 10px;
        }

        .table-nest table {
            position: relative;
            right: -1px;
            bottom: -1px;
        }

        .mod-justicedetail > h3 {
            text-align: center;
            line-height: 24px;
        }

        .mod-justicedetail > p {
            line-height: 24px;
            text-indent: 24px;
        }

        .table-gudong .col-first {
            width: 250px;
        }

        .table-gudong .col-second {
            width: 230px;
        }

        .table-gudong .col-three {
            width: 230px;
        }

        .table-gudong .col-four {
            width: 115px;
        }

        .table-gudong .col-five {
            width: 115px;
        }

        .table-gudong td tr {
            background: #f7f8fa;
        }

        .company-about .notice-pagination-box {
            text-align: center;
            padding-top: 20px;
        }

        .renyuan-list {
            margin-bottom: -20px;
        }

        .renyuan-list .item {
            float: left;
            padding-top: 8px;
            padding-bottom: 10px;
            margin-right: 12px;
            margin-bottom: 20px;
            width: 120px;
            height: 60px;
            border: 1px solid #e6e6e6;
            background: #f7f8fa;
            text-align: center;
            box-sizing: border-box;
        }

        .renyuan-list .item span {
            display: block;
            line-height: 20px;
        }

        .renyuan-list .item .manager {
            color: #797979;
        }

        .renyuan-list .item.item2 {
            width: 344px;
            height: auto;
            margin-right: 6px;
            padding-left: 14px;
            text-align: left;
        }

        .renyuan-list .item .title {
            line-height: 28px;
            color: #333;
        }

        .renyuan-list .item p {
            font-size: 12px;
            color: #666;
            line-height: 28px;
        }

        .renyuan-list .item.item3 {
            width: 465px;
            height: 150px;
            margin-right: 0;
            margin-bottom: 10px;
            padding-top: 10px;
            padding-left: 10px;
            padding-right: 3px;
            text-align: left;
            font-size: 14px;
        }

        .renyuan-list .item.item3:nth-child(odd) {
            margin-right: 10px;
        }

        .renyuan-list .item.item3 p {
            font-size: 14px;
        }

        .renyuan-list .item.item3 .pic {
            float: left;
            margin-right: 12px;
            width: 232px;
            height: 125px;
        }

        .renyuan-list .item.item3 .pic img {
            width: 100%;
        }

        .table-jigou .col-first {
            width: 87px;
        }

        .table-jigou .col-second {
            width: 250px;
        }

        .table-jigou .col-three {
            width: 380px;
        }

        .table-jigou .col-four {
            width: 220px;
        }

        .table-biegeng .col-first {
            width: 145px;
        }

        .table-biegeng .col-second {
            width: 340px;
        }

        .table-biegeng .col-three {
            width: 340px;
        }

        .table-biegeng .col-four {
            width: 112px;
        }

        .table-xuke .col-first {
            width: 45px;
        }

        .table-xuke .col-second {
            width: 130px;
        }

        .table-xuke .col-three {
            width: 130px;
        }

        .table-xuke .col-four {
            width: 112px;
        }

        .table-xuke .col-five {
            width: 112px;
        }

        .table-xuke .col-six {
            width: 150px;
        }

        .table-xuke .col-seven {
            width: 150px;
        }

        .table-xuke .col-eight {
            width: 50px;
        }

        .table-xuke .col-nine {
            width: 50px;
        }

        .table-xuke .tip2 {
            padding: 10px 0 10px 58px;
            color: #f92220;
            background: #fff;
        }

        .table-common.table-qingsuan tr:nth-child(even),
        .table-common.table-qingsuan tr:nth-child(even) {
            background: #f5f5f5;
        }

        .table-qingsuan td {
            text-indent: 20px;
        }

        .table-qingsuan .col-first {
            width: 180px;
        }

        .table-qingsuan .col-second {
            width: 230px;
        }

        .table-qingsuan .col-three {
            width: 210px;
        }

        .table-qingsuan .col-four {
            width: 210px;
        }

        .table-qingsuan .col-five {
            width: 210px;
        }

        .inner-table-common tr {
            background: none !important;
        }

        .table-common tr {
            background: #f9f9f9;
        }

        .table-common tr:nth-child(even),
        .table-common tr:nth-child(even) .inner-table tr {
            background: #f7f8fa;
        }

        .table-common tr:nth-child(odd) {
            background: #f5f5f5;
        }

        .table-common.table-chufa tr:nth-child(even) {
            background: #fff;
        }

        .table-chufa .tip2 {
            padding: 10px 0 10px 58px;
            color: #f92220;
        }

        .table-chufa .tip2 p {
            text-align: left;
        }

        .nianbao {
            padding: 12px;
            position: relative;
            background: #fff;
        }

        .nianbao select {
            position: absolute;
            top: 12px;
            left: 12px;
            border: 1px solid #aaa;
        }

        .nianbao .time {
            position: absolute;
            top: 18px;
            right: 8px;
            font-size: 14px;
            color: #adadad;
        }

        .nianbao-con {
            text-align: center;
        }

        .nianbao-con .title {
            margin-bottom: 10px;
        }

        .nianbao-con h3 {
            margin-right: 6px;
            height: 36px;
            font-size: 30px;
            color: #996666;
            display: inline-block;
            vertical-align: middle;
        }

        .nianbao-con a {
            display: inline-block;
            padding: 0 6px;
            height: 18px;
            line-height: 16px;
            font-size: 12px;
            color: #eb5857;
            border: 1px solid #eb5857;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
        }

        .nianbao-con p {
            font-size: 16px;
            color: #F92220;
        }

        .table-zichan td.odd {
            padding-right: 6px;
            font-weight: 700;
            color: #9b7d46;
            background: #eae3db;
        }

        .table-zichan td:nth-child(2n) {
            padding-left: 6px;
        }

        .table-punishdetail td:nth-child(even) {
            background: #fff;
        }

        .table-wfsx th {
            padding: 10px 0;
            line-height: 18px;
        }

        .detail-main {
            margin-bottom: 10px;
            padding: 5px;
            background-color: #ca9a37;
            box-sizing: border-box;
        }

        .detail-main .tab-panel {
            background: #fbfbfb;
        }

        .tab-header-outer {
            padding: 10px 5px 0;
            background-color: #ca9a37;
            box-sizing: border-box;
        }

        .tab-header.tab-detail {
            padding: 8px 0 8px 12px;
            background: #fff;
        }

        .tab-header.tab-detail li {
            float: left;
            margin-right: 12px;
            line-height: 28px;
            color: #ccc;
        }

        .tab-header.tab-detail a {
            display: inline-block;
            padding: 0 13px;
            font-size: 16px;
            color: #333;
            line-height: 28px;
        }

        .tab-header.tab-detail a:hover {
            color: #f66262
        }

        .tab-header.tab-detail .tab-selected a {
            color: #fff;
            background: #F66262;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
        }

        .mb10 {
            margin-bottom: 10px;
        }

        /* 主体填报公示信息 */
        .mod.reported-info {
            margin-top: 82px;
        }

        .reported-info .title {
            margin-bottom: 20px;
            font-size: 28px;
            color: #333;
            line-height: 46px;
            border-bottom: 1px solid #e7dcc5;
        }

        .reported-list {
            margin-bottom: 100px;
        }

        .reported-list li {
            float: left;
            padding-top: 23px;
            width: 249px;
            text-align: center;
        }

        .reported-list li.line {
            width: 1px;
            height: 280px;
            background: #ede7d9;
        }

        .reported-list i {
            display: inline-block;
            height: 120px;
        }

        .reported-list .company {
            width: 110px;
            background: url(/img/pub/company.png);
        }

        .reported-list .individual {
            width: 145px;
            background: url(/img/pub/individual.png);
        }

        .reported-list .peasants-cooperative {
            width: 110px;
            background: url(/img/pub/peasants_cooperative.png);
        }

        .reported-list .organization-representative {
            width: 120px;
            background: url(/img/pub/organization_representative.png);
        }

        .reported-list .btn-box {
            width: 220px;
            margin: 0 auto;
        }

        .reported-list .btn {
            display: table-cell;
            width: 220px;
            height: 64px;
            font-size: 18px;
            vertical-align: middle;
            color: #fff;
            background: #ab812d;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
        }

        .reported-list .btn:hover {
            background: #cc0000;
        }

        .reported-list .btn.disabled {
            background: #ccc;
        }

        .reported-list .notice.disabled {
            color: #ccc;
        }

        .reported-list h3 {
            display: table-cell;
            padding-bottom: 18px;
            width: 253px;
            height: 73px;
            font-size: 24px;
            vertical-align: middle;
        }

        .notice {
            font-size: 16px;
            line-height: 36px;
            color: #ff0000;
        }

        .notice:hover {
            color: #685010;
        }

        .contact-mod {
            padding: 4px 6px 8px;
            background-color: #ca9a37;
            box-sizing: border-box;
        }

        .contact-mod .contact-mod-hd {
            background: #fff;
            padding-bottom: 20px;
        }

        .contact-mod .mod-bd-panel_company {
            border-bottom: 0;
            padding: 0 24px 0;
        }

        .contact-mod .table-common td {
            height: 26px;
        }

        .contact-mod .table-common th {
            color: #804000;
        }

        .contact-mod .table-common tr:nth-child(odd) {
            background: #f7f8fa;
        }

        .load-more {
            border-bottom: 1px dashed #d5b661;
            position: relative;
            height: 20px;
        }

        .load-more span {
            position: absolute;
            top: 9px;
            left: 50%;
            margin-left: -33px;
            padding: 0 5px;
            color: #ff962d;
            background: #fff;
            cursor: pointer;
        }

        .h-320 {
            height: 320px;
            overflow: hidden;
        }

        .h-372 {
            height: 372px;
            overflow: hidden;
        }

        .decision-con {
            padding: 0 0 20px 0;
            border: 1px solid #efefef;
            color: #555;
        }

        .decision-con h3 {
            font-size: 18px;
            text-align: center;
            line-height: 36px;
        }

        .decision-con .title-bar {
            font-size: 16px;
            text-align: center;
            line-height: 36px;
            margin-bottom: 24px;
        }

        .decision-con p {
            padding-left: 180px;
            line-height: 20px;
        }

        .exceptionlist-layer {
            display: none;
            position: absolute;
            left: 0;
            top: 29px;
            z-index: 1;
            width: 100%;
            padding: 10px 10px 14px;
            font-size: 12px;
            border: 1px solid #ccc;
            background: #f8f8f8;
            box-sizing: border-box;
        }

        .exceptionlist-layer h3 {
            color: #EB5857;
            line-height: 24px;
        }

        .company-basic .exceptionlist-layer p {
            line-height: 18px;
            color: #333;
            font-weight: normal;
        }

        .exceptionlist-layer .line {
            display: inline-block;
            width: 100%;
            height: 1px;
            border-bottom: 1px dashed #333;
            margin-bottom: 4px;
        }

        .exceptionlist-layer .close {
            position: absolute;
            top: 2px;
            right: 5px;
            display: inline-block;
            font-size: 14px;
            padding: 3px;
            color: #333;
            cursor: pointer;
        }

        .pos-fixed {
            position: fixed;
            top: 0;
        }

        #back-to-top {
            position: fixed;
            display: none;
            bottom: 310px;
            right: 50px;
            width: 50px;
            height: 50px;
            border: 1px solid #ccc;
            text-align: center;
            background: #fff;
        }

        #back-to-top a {
            display: block;
            padding-top: 5px;
            color: #666;
            line-height: 20px;
            cursor: pointer;
        }

        .xzcf-notice {
            border: 1px solid #efefef;
            /*     height: 380px; */
            /*     line-height: 380px; */
            text-align: center;
            font-size: 14px;
            margin-top: 20px;
        }

        .info-tb-hd {
            padding: 17px 0 24px;
            font-size: 0px;
            background: #fff url(/img/pub/notice-header-bg.png) no-repeat right 0;
        }

        .info-tb-hd .logo {
            margin: 0 auto;
            width: 1112px;
        }

        .info-tb-hd .logo a {
            display: block;
            width: 598px;
            height: 68px;
            background: url(../img/pub/logo.png) no-repeat;
            font-size: 0;
        }

        .info-tb-cont {
            width: 936px;
            margin: 0 auto;
            margin-top: 64px;
            background-color: #fff;
            box-shadow: 3px 3px 6px #ccc;
            border-bottom-left-radius: 4px;
            border-bottom-right-radius: 4px;
        }

        .info-tab-hd {
            background-color: #ab812d;
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
            padding: 13px 0 0 37px;
        }

        .info-tab-hd li {
            float: left;
            color: #fff;
            font-size: 18px;
            height: 35px;
            line-height: 35px;
            border-top-left-radius: 2px;
            border-top-right-radius: 2px;
            margin-right: 8px;
            padding: 0 15px;
            cursor: pointer;
        }

        .info-tab-hd li.cur {
            color: #AB812D;
            background-color: #fff;
        }

        .info-tab-hd .turn-back {
            position: absolute;
            right: 10px;
            top: 8px;
            width: 80px;
            height: 30px;
            background-color: #d1ab62;
            color: #fff;
            border-radius: 2px;
            line-height: 30px;
            text-align: center;
        }

        .info-tab-cont .item {
            min-height: 386px;
        }

        .info-tab-cont label {
            font: normal 14px/25px 'Microsoft YaHei';
            color: #333;
            float: left;
            text-align: right;
            width: 180px;
            padding-right: 10px;
        }

        .info-tab-cont .gslly-log {
            padding: 43px 0 37px 220px;
        }

        .info-tab-cont label span {
            display: inline-block;
            background: url("../img/pub/info-tb-icon.png") no-repeat 0 3px;
            padding-left: 20px;
        }

        .info-tab-cont input[type='text'] {
            border: 1px solid #a9a9a9;
            box-sizing: border-box;
            height: 25px;
            width: 300px;
            float: left;
            text-indent: 4px;
        }

        .info-tab-cont input[type='text']:disabled {
            background-color: rgb(235, 235, 228);
        }

        .info-tab-cont input.yzm {
            width: 135px;
            margin-right: 26px;
        }

        .info-tab-cont .hq-yzm {
            font: normal 14px/25px 'Microsoft YaHei';
            color: #fff;
            background-color: #ffab30;
            padding: 0 8px 0 22px;
            float: left;
            border-radius: 3px;
            cursor: pointer;
        }

        .info-tab-cont .log-btn input {
            font: normal 14px/28px 'Microsoft YaHei';
            min-width: 90px;
            text-align: center;
            height: 28px;
            color: #fff;
            background-color: #ab812d;
            border-radius: 4px;
            padding: 0 25px;
            cursor: pointer;
        }

        .gsll-tip {
            font: normal 16px/18px 'Microsoft YaHei';
            margin: 26px 0 34px 0;
        }

        .report-layer {
            width: 370px;
            height: 240px;
            background: #fff;
        }

        .report-layer h3 {
            width: 370px;
            height: 40px;
            line-height: 40px;
            color: #fff;
            text-indent: 26px;
            background: #d5b661;
            border-radius: 3px 3px 0 0;
        }

        .report-layer .content .title {
            margin: 32px 0 0 38px;
            color: #333;
        }

        .report-layer .content .ipt-box {
            margin: 22px 0 0 70px;
        }

        .report-layer .content .ipt-txt {
            width: 210px;
            height: 30px;
            padding: 0 2px;
            border: 1px solid #a9a9a9;
            box-sizing: border-box;
        }

        .report-layer .content .btn-box {
            margin-top: 38px;
            text-align: center;
        }

        .report-layer .content .btn {
            font-size: 14px;
            color: #fff;
            width: 87px;
            height: 31px;
            background: #d5b661;
            border-radius: 3px;
            cursor: pointer;
            font-weight: bold;
        }

        .report-layer .content .text {
            padding: 54px 0 16px 0;
            text-align: center;
        }

        .report-mail {
            padding: 20px 22px;
            width: 865px;
            height: 380px;
            box-sizing: border-box;
            background: #fff;
        }

        .report-mail h3 {
            font-size: 18px;
            font-weight: bold;
            padding-bottom: 5px;
        }

        .report-mail .owner {
            padding-bottom: 4px;
        }

        .report-mail .owner p {
            font-size: 12px;
            line-height: 20px;
            color: #333;
        }

        .report-mail .owner .hide {
            float: right;
            color: #3a6298;
        }

        .report-mail .grey {
            color: #9d9d9d;
        }

        .report-mail .report-name {
            padding: 12px 0 20px 0;
            color: #333;
            font-size: 12px;
        }

        .report-mail .report-name i {
            display: inline-block;
            width: 12px;
            height: 16px;
            margin-right: 5px;
            background: url(/img/pub/pdf-icon.jpg) no-repeat;
            vertical-align: -2px;
        }

        .report-mail .toolbar i {
            display: inline-block;
        }

        .report-mail .toolbar .reply-icon {
            width: 14px;
            height: 11px;
            background: url(/img/pub/reply-icon.jpg) no-repeat;
        }

        .report-mail .toolbar .forward-icon {
            width: 12px;
            height: 11px;
            background: url(/img/pub/forward-icon.jpg) no-repeat;
        }

        .report-mail .line-lightblue {
            width: 100%;
            border-top: 1px solid #dde4ea;
        }

        .report-mail .con {
            position: relative;
        }

        .report-mail .toolbar {
            position: absolute;
            top: -12px;
            left: 50%;
            margin-left: -70px;
            width: 139px;
            height: 21px;
            border: 1px solid #dde4ea;
            background: #fff;
            border-radius: 10px;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            -ms-border-radius: 10px;
        }

        .report-mail .toolbar i {
            margin-right: 3px;
        }

        .report-mail .toolbar .item {
            float: left;
            width: 68px;
            padding-left: 14px;
            padding-top: 2px;
            font-size: 12px;
            box-sizing: border-box;
            cursor: pointer;
        }

        .report-mail .toolbar .line {
            float: left;
            margin-top: 5px;
            width: 1px;
            height: 12px;
            background: #99a1a8;
        }

        .report-mail .con {
            color: #000;
        }

        .report-mail .con .hi {
            margin: 10px 0 14px 0;
        }

        .report-mail .con p {
            padding-left: 40px;
            line-height: 20px;
        }

        .report-mail .con .foot {
            margin-top: 34px;
        }

        .report-layer .share-icon {
            margin: 0 auto;
            padding-top: 40px;
            padding-left: 3px;
            padding-bottom: 56px;
            width: 160px;
            height: 60px;
            background: url(/img/pub/share-icon.png) no-repeat -23px 40px;
        }

        .report-layer .share-icon a {
            float: left;
            margin: 16px 6px 0 0;
            width: 32px;
            height: 32px;
        }

        .report-layer .close {
            float: right;
            padding-top: 8px;
            padding-right: 12px;
            padding-bottom: 10px;
            width: 22px;
            height: 19px;
            background: url(/img/pub/close.png) no-repeat 2px 8px;
            cursor: pointer;
        }

        .border-box2 {
            border-top: 10px solid #ca9a37;
            border-left: 5px solid #ca9a37;
            border-bottom: 10px solid #ca9a37;
            border-right: 5px solid #ca9a37;
            background-color: #fff;
            padding: 34px;
            margin-top: 50px;
            margin-bottom: 40px;
        }

        .border-box2 .btn {
            background: url(/img/pub/btn.png);
            display: inline-block;
            width: 95px;
            height: 35px;
            line-height: 35px;
            text-align: center;
            color: #fff;
            font-size: 14px;
            font-family: "Microsoft Yahei";

        }

        .header-se {
            width: 1036px;
        }

        .mod-1330 {
            width: 1330px;
            margin: 0 auto;
        }
        .mod-1078 {
            width: 1078px;
            margin: 0 auto;
        }
        .info-print {
            overflow: hidden;
            background: #fff;
        }

        .info-print .print-icon {
            margin-top: 60px;
            margin-left: 1150px;
            cursor: pointer;
            width: 60px;
            height: 80px;
            padding-top: 60px;
            background: url(/img/pub/print-icon.jpg) no-repeat;
            text-align: center;
            box-sizing: border-box;
        }

        .info-print .logo {
            margin: 100px auto 140px;
            width: 837px;
            height: 365px;
            background: url(/img/pub/infoprint.png) no-repeat;
        }

        .info-print .title-name {
            margin-bottom: 334px;
            font-size: 60px;
            font-weight: bold;
            text-align: center;
            line-height: 60px;
        }

        .info-print .about {
            padding-left: 350px;
            margin-bottom: 160px;
        }

        .info-print .about p {
            font-size: 30px;
            line-height: 60px;
        }

        .info-print .about label {
            float: left;
            width: 290px;
            font-weight: bold;
        }

        .info-print .tips {
            text-align: center;
            font-size: 20px;
        }

        .info-print h2 {
            color: #804000;
            line-height: 50px;
            border-top: 3px solid #ccc;
            border-bottom: 3px solid #ccc;
        }

        .mod-1080 {
            margin: 0 auto;
            width: 1080px;
        }

        .info-print .encounter-info li .title {
            color: #000;
        }

        .border-b-gray {
            border-bottom: 1px solid #c9c5c6;
        }

        .mod-bd-panel_company.no-borderlr {
            border-left: none;
            border-right: none;
        }

        .info-print .mod-bd-panel_company {
            padding-left: 0;
            padding-right: 0;
        }

        .info-print .mod-bd-panel_company .no-con {
            line-height: 44px;
            text-align: center;
            border: 1px solid #efefef;
            background: #f9f9f9;
        }

        .qyzc-info{
            padding-right: 15px;
            font-weight: 600;
        }

        .fj-title{
            font-size: 18px;
            text-decoration: underline;
        }
        .info-print .table-common tr:nth-child(odd) table tr {
            background: none;
        }
        .info-print .table-common tr:nth-child(odd) table td {
            font-weight: bold;
        }
        .no-borderb {
            border-bottom: none;
        }

        input[readonly]{
            background-color: rgb(235, 235, 228);
            color:#666;
        }





    </style>
</head>
<body>
<div class="mod-1330 info-print">

    <div class="logo">
        <img src="infoprint.png" />
    </div>

    <div class="title-name">企业信用信息公示报告</div>
    <div class="about">
        <p><label>企业名称</label>
        <#if entBasicInfo.entName??>
        ${entBasicInfo.entName }</#if></p>
        <p><label>报告生成时间</label>
        <#if createTime??>
        ${createTime}</#if></p>
    </div>
    <img src="shuiyin.png" />
    <div class="tips">（报告内容仅供参考，具体内容请以国家企业信用信息公示系统查询页面为准）</div>
    <div class="mod-1080">
        <h2>政府部门公示信息</h2>
        <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
            <h3 class="i-title">
                <i></i>营业执照信息
            </h3>

            <ul class="encounter-info clearfix">
            <#if entBasicInfo.entTypeCatg??>
                <#if '12,14,34,32,22,28,24'?index_of(entBasicInfo.entTypeCatg)!=-1>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                                <span>
                                    <#if uniCode??>
		                        ${uniCode}
		                        </#if>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                                <span>
                                    <#if entBasicInfo.entName??>
                                ${entBasicInfo.entName } </#if>
                                </span>

                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                                <span>
                                    <#if entBasicInfo.entTypeName??>
                                ${entBasicInfo.entTypeName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>负责人：</span>
                                <span>
                                    <#if entBasicInfo.leRep??>
                                ${entBasicInfo.leRep } </#if> </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>营业期限自：</span>
                                <span>
                                    <#if entBasicInfo.opFromStr??>
                                ${entBasicInfo.opFromStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>营业期限至：</span>
                                <span>
                                    <#if entBasicInfo.opToStr??>
                                ${entBasicInfo.opToStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span><#if entBasicInfo.regOrgName??>${entBasicInfo.regOrgName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span><#if entBasicInfo.estDateStr??>${entBasicInfo.estDateStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                                <span>
                                    <#if entBasicInfo.regState??>
                                        <#if  entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'>
                                            存续
                                        </#if>
                                        <#if entBasicInfo.regState=='DA'>
                                            吊销未注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='D'>
                                            吊销
                                        </#if>
                                    </#if>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                                <span>
                                    <#if entBasicInfo.apprDateStr??>
                                ${entBasicInfo.apprDateStr} </#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>营业场所：</span>
                                <span>
                                    <#if entBasicInfo.dom??>
                                ${entBasicInfo.dom }</#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span><#if entBasicInfo.opScope??>${entBasicInfo.opScope }</#if></span>
                    </li>
                </#if>
            </#if>
            <#if entBasicInfo.entTypeCatg??>
                <#if '11,21,13'?index_of(entBasicInfo.entTypeCatg)!=-1>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                        <span> <#if uniCode??>${uniCode}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span><#if entBasicInfo.entName??>${entBasicInfo.entName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span><#if entBasicInfo.entTypeName??>${entBasicInfo.entTypeName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>法定代表人：</span>
                        <span><#if entBasicInfo.leRep??>${entBasicInfo.leRep }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>注册资本：</span>
                        <span><#if entBasicInfo.regCap?? >${entBasicInfo.regCap }万${entBasicInfo.currencyCn}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span><#if entBasicInfo.estDateStr??>${entBasicInfo.estDateStr }</#if></span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if '11,21'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                营业期限自：
                            </#if>
                            <#if  '13'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营期限自：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.opFromStr??>${entBasicInfo.opFromStr}</#if></span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if '11,21'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                营业期限至：
                            </#if>
                            <#if '13'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营期限至：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.opToStr??>${entBasicInfo.opToStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span><#if entBasicInfo.regOrgName??>${entBasicInfo.regOrgName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span><#if entBasicInfo.apprDateStr??>${entBasicInfo.apprDateStr}</#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                                <span>
                                    <#if entBasicInfo.regState??>
                                        <#if  entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'>
                                            存续
                                        </#if>
                                        <#if  entBasicInfo.regState=='DA'>
                                            吊销未注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='D'>
                                            吊销
                                        </#if>
                                    </#if>
	                    </span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>住所：</span>
                        <span><#if entBasicInfo.dom??>${entBasicInfo.dom }</#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span><#if entBasicInfo.opScope??>${entBasicInfo.opScope }</#if></span>
                    </li>
                </#if>
            </#if>
            <#if entBasicInfo.entTypeCatg??>
                <#if  '33,27'?index_of(entBasicInfo.entTypeCatg)!=-1>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                                <span>
                                    <#if uniCode??>${uniCode}</#if>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span><#if entBasicInfo.entName??>${entBasicInfo.entName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span><#if entBasicInfo.entTypeName??>${entBasicInfo.entTypeName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>执行事务合伙人：</span>
                        <span><#if entBasicInfo.leRep??>${entBasicInfo.leRep }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>合伙期限自：</span>
                        <span><#if entBasicInfo.opFromStr??>${entBasicInfo.opFromStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>合伙期限至：</span>
                        <span><#if entBasicInfo.opToStr??>${entBasicInfo.opToStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span><#if entBasicInfo.regOrgName??>${entBasicInfo.regOrgName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span><#if entBasicInfo.estDateStr??>${entBasicInfo.estDateStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                                <span>
                                    <#if entBasicInfo.regState??>
                                        <#if  entBasicInfo.regState=='K'||entBasicInfo.regState=='B'||entBasicInfo.regState=='A'||entBasicInfo.regState=='DA'||entBasicInfo.regState=='X'||entBasicInfo.regState=='Q'>
                                            存续
                                        </#if>
                                        <#if  entBasicInfo.regState=='C'>
                                            撤销
                                        </#if>
                                        <#if  entBasicInfo.regState=='D'>
                                            吊销
                                        </#if>
                                        <#if  entBasicInfo.regState=='XX'>
                                            注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='DX'>
                                            吊销已注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='QX'>
                                            迁出已注销
                                        </#if>
                                    </#if>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span><#if entBasicInfo.apprDateStr??>${entBasicInfo.apprDateStr}</#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>主要经营场所：</span>
                        <span><#if entBasicInfo.dom ??>${entBasicInfo.dom }</#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                        <span><#if entBasicInfo.opScope??>${entBasicInfo.opScope }</#if></span>
                    </li>
                </#if>
            </#if>
            <#if entBasicInfo.entTypeCatg??>
                <#if  '31,17'?index_of(entBasicInfo.entTypeCatg)!=-1>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                        <span><#if uniCode??> ${uniCode} </#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                        <span><#if entBasicInfo.entNam??>${entBasicInfo.entName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span><#if entBasicInfo.entTypeName??>${entBasicInfo.entTypeName }</#if></span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if '31'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                投资人：
                            </#if>
                            <#if  '17'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                负责人：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.leRep??>${entBasicInfo.leRep }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span><#if entBasicInfo.regOrgName??>${entBasicInfo.regOrgName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                        <span><#if entBasicInfo.estDateStr??>${entBasicInfo.estDateStr}</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                                <span>
                                    <#if entBasicInfo.regState??>
                                        <#if  entBasicInfo.regState=='K'||entBasicInfo.regState=='A'||entBasicInfo.regState=='B'>
                                            存续
                                        </#if>
                                        <#if entBasicInfo.regState=='DA'>
                                            吊销未注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='D'>
                                            吊销
                                        </#if>
                                    </#if>
	                    </span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span><#if entBasicInfo.apprDateStr??>${entBasicInfo.apprDateStr}</#if></span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
	                    	<em>• </em>
                            <#if '31'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                住所：
                            </#if>
                            <#if  '17'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营场所：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.dom??>${entBasicInfo.dom }</#if></span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if  '31'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营范围：
                            </#if>
                            <#if  '17'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                业务范围：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.opScope??>${entBasicInfo.opScope }</#if></span>
                    </li>
                </#if>
            </#if>
            <#if entBasicInfo.entTypeCatg??>
                <#if  '50,16'?index_of(entBasicInfo.entTypeCatg)!=-1>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                        <span><#if  uniCode??> ${uniCode}</#if></span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if '50'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                名称：
                            </#if>
                            <#if  '16'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                企业名称：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.entName??>${entBasicInfo.entName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>类型：</span>
                        <span><#if entBasicInfo.entTypeName??>${entBasicInfo.entTypeName }</#if></span>
                    </li>
                    <li>
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if  '50'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营者：
                            </#if>
                            <#if  '16'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                法定代表人：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.leRep??> ${entBasicInfo.leRep }</#if></span>
                    </li>
                    <#if  '50'?index_of(entBasicInfo.entTypeCatg)!=-1>
                        <li>
                            <span class="title right qyzc-info"><em>• </em>组成形式：</span>
                            <span><#if entBasicInfo.compFormName??> ${entBasicInfo.compFormName }</#if></span>
                        </li>
                        <li>
                            <span class="title right qyzc-info"><em>• </em>注册日期：</span>
                            <span><#if entBasicInfo.estDateStr??>${entBasicInfo.estDateStr}</#if></span>
                        </li>
                    </#if>
                    <#if   '16'?index_of(entBasicInfo.entTypeCatg)!=-1>
                        <li>
                            <span class="title right qyzc-info"><em>• </em>成员出资总额：</span>
                            <span><#if entBasicInfo.regCap??>${entBasicInfo.regCap }万${entBasicInfo.currencyCn}</#if></span>
                        </li>
                        <li>
                            <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                            <span><#if entBasicInfo.estDateStr??>${entBasicInfo.estDateStr}</#if></span>
                        </li>
                    </#if>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                        <span><#if entBasicInfo.regOrgName??>${entBasicInfo.regOrgName }</#if></span>
                    </li>
                    <li>
                        <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                        <span><#if entBasicInfo.apprDateStr??>${entBasicInfo.apprDateStr}</#if></span>
                    </li>
                    <li class="item-width">
                        <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                                <span>
                                    <#if entBasicInfo.regState??>
                                        <#if  entBasicInfo.regState=='K'||entBasicInfo.regState=='B'||entBasicInfo.regState=='A'||entBasicInfo.regState=='DA'||entBasicInfo.regState=='X'||entBasicInfo.regState=='Q'>
                                            存续
                                        </#if>
                                        <#if  entBasicInfo.regState=='C'>
                                            撤销
                                        </#if>
                                        <#if  entBasicInfo.regState=='D'>
                                            吊销
                                        </#if>
                                        <#if  entBasicInfo.regState=='XX'>
                                            注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='DX'>
                                            吊销已注销
                                        </#if>
                                        <#if  entBasicInfo.regState=='QX'>
                                            迁出已注销
                                        </#if>
                                    </#if>
	                    </span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if  '50'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营场所：
                            </#if>
                            <#if  '16'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                住所：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.dom??>${entBasicInfo.dom }</#if></span>
                    </li>
                    <li class="item-width">
	                    <span class="title right qyzc-info">
							<em>• </em>
                            <#if  '50'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                经营范围：
                            </#if>
                            <#if  '16'?index_of(entBasicInfo.entTypeCatg)!=-1>
                                业务范围：
                            </#if>
	                    </span>
                        <span><#if entBasicInfo.opScope??>${entBasicInfo.opScope }</#if></span>
                    </li>
                </#if>
            </#if>




            </ul>
        </div>
    <#if entBasicInfo.entTypeCatg??>
        <#if '13'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>主管部门（出资人）信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>出资人类型</th>
                            <th>出资人</th>
                            <th>证照/证件类型</th>
                            <th>证照/证件号码</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">

                            <#if (listMId?size==0)>
                            <tr><td  colspan="5"><div class="no-con">暂无主管部门（出资人）信息 </div></td></tr>

                            <#else>
                                <#list listMId as mid>
                                <tr>
                                    <td>${mid_index}</td>
                                    <td>
                                        <#if mid.invType=="1">
                                            企业法人
                                        <#else>
                                            自然人
                                        </#if>
                                    </td>
                                    <td><#if mid.inv??>${mid.inv}</#if></td>
                                    <td>
                                        <#if mid.invType=="1">
                                            <#if mid.bLicType?? && mid.bLicType=="1">
                                                法人营业执照
                                            </#if>
                                        <#else>
                                            <#if mid.cerTypeName??>
                                            ${mid.cerTypeName}
                                            </#if>
                                        </#if>
                                    </td>
                                    <td>
                                        <#if mid.invType??>
                                            <#if mid.invType=="1">
                                                <#if mid.bLicNO??>
                                                ${mid.bLicNO}
                                                </#if>
                                            <#else>
                                                （非公式项）
                                            </#if>
                                        </#if>
                                    </td>
                                </tr>

                                </#list>

                            </#if>
                        </tbody>

                    </table>
                </div>
            </div>
        </#if>
    </#if>
    <#if entBasicInfo.entTypeCatg??>
        <#if '31'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>投资人信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>出资方式</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">
                            <#if listMId?size==0>
                            <tr><td  colspan="3"><div class="no-con">暂无投资人信息 </div></td></tr>
                            <#else>
                                <#list listMId  as mid>
                                <tr>
                                    <td>${mid_index}</td>
                                    <td><#if mid.inv??>${mid.inv}</#if></td>
                                    <td><#if mid.sConForm??>${mid.sConForm}</#if></td>
                                </tr>
                                </#list>
                            </#if>
                        </tbody>
                    </table>

                </div>
            </div>
        </#if>
    </#if>
    <#if entBasicInfo.entTypeCatg??>
        <#if  '33,27'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>合伙人信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>合伙人</th>
                            <th>合伙人类型</th>
                            <th>证照/证件类型</th>
                            <th>证照/证件号码</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">

                            <#if listMId?size==0>
                            <tr><td  colspan="5"><div class="no-con">暂无主管部门（出资人）信息 </div></td></tr>
                            <#else>
                                <#list listMId as mid>
                                <tr>
                                    <td>${mid_index}</td>
                                    <td>
                                        <#if mid.invType??>
                                            <#if mid.invType=="1">
                                                企业法人
                                            <#else>
                                                自然人
                                            </#if>
                                        </#if>
                                    </td>
                                    <td><#if mid.inv??>${mid.inv}</#if></td>
                                    <td>
                                        <#if mid.invType=="1">
                                            <#if mid.bLicType?? && mid.bLicType=="1">
                                                法人营业执照
                                            </#if>
                                        <#else>
                                            <#if mid.cerTypeName??>
                                            ${mid.cerTypeName}
                                            </#if></#if></td>
                                    <td>
                                        <#if mid.invType??>
                                            <#if mid.invType=="1">
                                                <#if mid.bLicNO??>
                                                ${mid.bLicNO}
                                                </#if>
                                            <#else>
                                                （非公式项）
                                            </#if>
                                        </#if>
                                    </td>
                                </tr>

                                </#list>

                            </#if>

                        </tbody>
                    </table>

                </div>
            </div>
        </#if>
    </#if>

    <#if entBasicInfo.entTypeCatg??>
        <#if  '11,21'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod company-about">
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>股东及出资信息
                    </h3>
                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th width="45px;">股东类型</th>
                            <th>股东</th>
                            <th>证照/证件类型</th>
                            <th>证照/证件号码</th>
                        </tr>
                        </thead>
                        <tbody id="table-midinv_stock">

                            <#if listMId?size==0>
                            <tr><td  colspan="5"><div class="no-con">暂无主管部门（出资人）信息 </div></td></tr>
                            <#else>
                                <#list listMId as mid>
                                <tr>
                                    <td>${mid_index}</td>
                                    <td>
                                        <#if mid.invType=="1">
                                            企业法人
                                        <#else>
                                            自然人
                                        </#if>
                                    </td>
                                    <td>${mid.inv}</td>
                                    <td>
                                        <#if mid.invType=="1">
                                            <#if mid.bLicType?? && mid.bLicType=="1">
                                                法人营业执照
                                            </#if>
                                        <#else>
                                            <#if mid.cerTypeName??>
                                            ${mid.cerTypeName}
                                            </#if>
                                        </#if></td>
                                    <td>
                                    <td>
                                        <#if mid.invType??>
                                            <#if mid.invType=="1">
                                                <#if mid.bLicNO??>
                                                ${mid.bLicNO}
                                                </#if>
                                            <#else>
                                                （非公式项）
                                            </#if>
                                        </#if>
                                    </td>

                                    </td>
                                </tr>

                                </#list>

                            </#if>

                        </tbody>
                    </table>

                </div>
            </div>
        </#if> </#if>
    <#if entBasicInfo.entTypeCatg??>
        <#if  '11,21'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>主要人员信息

                    <span class="number" id="member"></span>
                </h3>
                <div class="renyuan-list member clearfix">
                    <#if listMem?size!=0>
                        <#list listMem as item>
                            <div class="item">
                                <span><#if item.name??>${item.name}</#if></span>
                                <span class="manager"><#if item.posiContent??>${item.posiContent}</#if></span>
                            </div>
                        </#list>
                    </#if>
                </div>
            </div>
        </#if> </#if>
    <#if entBasicInfo.entTypeCatg??>
        <#if  '50'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>参加经营的家庭成员姓名
                    <span class="number" id="member"></span>
                </h3>
                <div class="renyuan-list member clearfix">

                    <#list listMem as item>
                        <div class="item">
                            <span><#if item.name??>${item.name}</#if></span>
                            <span class="manager"><#if item.posiContent??>${item.posiContent}</#if></span>
                        </div>
                    </#list>

                </div>
            </div>
        </#if>  </#if>
    <#if entBasicInfo.entTypeCatg??>
        <#if  '16'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>成员名册
                    <span class="number" id="memberinv"></span>
                </h3>
                <div class="renyuan-list memberinv clearfix">

                    <#if memberinv?size!=0>
                        <#list memberinv as item>
                            <div class="item">
                                <span><#if item.inv??>${item.inv}</#if></span> </div>
                        </#list>
                    </#if>
                </div>
            </div>
        </#if></#if>
    <#if entBasicInfo.entTypeCatg??>
        <#if '11,33,31,21,27'?index_of(entBasicInfo.entTypeCatg)!=-1>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>分支机构信息

                    <span class="number" id="midbranch"></span>
                </h3>
                <div class="renyuan-list branch clearfix">
                    <#if midBranchDtos?size!=0>
                        <#list midBranchDtos as item>

                            <div class='item item2'> <div class='title'><#if item.entName??>${item.entName}</div></#if>
                                <p>· 统一社会信用代码/注册号：<#if item.regNO??>${item.regNO}</#if></p> <p>· 登记机关：<#if item.regOrgName??>${item.regOrgName}</#if></p> </div>
                        </#list>
                    </#if>
                </div>
            </div>
        </#if></#if>


        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>变更信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="70">变更事项</th>
                    <th width="140">变更前内容</th>
                    <th width="140">变更后内容</th>
                    <th width="100">变更日期</th>
                </tr>
                </thead>

                <tbody id="table-midaltitem">
                <#if midAltitemDtos?size==0>

                <tr><td colspan="5"><div class="no-con">暂无变更信息 </div></td></tr>
                <#else>
                    <#list midAltitemDtos as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.altContent??>${item.altContent}</#if></td>
                        <td><#if item.altBeContent??>${item.altBeContent}</#if></td>
                        <td><#if item.altAfContent??>${item.altAfContent}</#if></td>
                        <td><#if item.altDate??>${(item.altDate?string("yyyy年MM月dd日"))!''}</#if></td>
                    </tr>

                    </#list>

                </#if>
                </tbody>
            </table>

        </div>

        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>清算信息
            </h3>
            <table class="table-common table-qingsuan">
                <thead>
                <tr>
                    <th class="col-first" colspan="5">
                        清算信息
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="title">清算组负责人</td>
                    <td colspan="<#if size??>${size}</#if>" class="left">
                    <#if midLiquidationDto??>
                       ${midLiquidationDto.ligPrincipal}
                    </#if>
                    </td>
                </tr>

                <tr width="50px;">
                    <td class="col-first title" rowspan="2">清算组成员</td>
                <#if (listLiu?size>0)>
                    <#list listLiu as item>
                        <td class="">${item}</td>
                    </#list>
                <#else>
                    <td></td>


                </#if>
                </tr>


                </tbody>
            </table>

        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title"> <i></i>行政许可信息 </h3>
            <table class="table-common table-xuke mb20">
                <thead>
                <tr>
                    <th class="col-first"> 序号 </th>
                    <th class="col-second"> 许可文件编号 </th>
                    <th class="col-three"> 许可文件名称 </th>
                    <th class="col-four"> 有效期自 </th>
                    <th class="col-five"> 有效期至 </th>
                    <th class="col-six"> 许可机关 </th>
                    <th class="col-seven"> 许可内容 </th>
                </tr>
                </thead>
                <tbody id="licenseinfo_listData">
                <#if otherList?size==0>
                <tr><td colspan="7"><div class="no-con">暂无行政许可信息 </div></td></tr>
                <#else>
                    <#list otherList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.licNO??>${item.licNO}</#if></td>
                        <td><#if item.item.licNameCN??>${item.licNameCN}</#if></td>
                        <td><#if item.licValFrom??>${(item.licValFrom?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.licValTo??>${(item.licValTo?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.licAnth??>${item.licAnth}</#if></td>
                        <td><#if item.licScope??>${item.licScope}</#if></td>
                    </tr>
                        <#if item.pubOtherlicenceModList?size>0>
                        <tr>
                            <td colspan="7" class="tip2">
                                <div class="fl">有变更情形：</div>
                                <div class="fl">
                                    <#list item.pubOtherlicenceModList as item>
                                        <p>${item_index}、<#if item.altDate??>${(item.altDate?string("yyyy年MM月dd日"))!''}</#if>将<#if item.altItem??>${item.altItem}</#if>
                                            由<#if item.altBe??>${item.altBe}</#if>变更为<#if item.altAf??>${item.altAf}</#if>。</p>
                                    </#list>
                                </div>
                            </td>
                        </tr>
                        </#if>

                    </#list>
                </#if>
                </tbody>
            </table>
        </div>





        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政处罚信息
            </h3>
            <table class="table-common table-chufa mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="155">决定书文号</th>
                    <th width="155">违法行为类型</th>
                    <th width="130">行政处罚内容</th>
                    <th width="155">决定机关名称</th>
                    <th width="110">处罚决定日期</th>
                    <th width="110">公示日期</th>
                </tr>
                </thead>
                <tbody id="punish_listData">
                <#if pushList?size==0>
                <tr><td colspan="7"><div class="no-con">暂无行政处罚信息 </div></td></tr>
                <#else>
                    <#list pushList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.penDecNo??>${item.penDecNo}</#if></td>
                        <td><#if item.illegActType??>${item.illegActType}</#if></td>
                        <td><#if item.penContent??>${item.penContent}</#if></td>
                        <td><#if item.judAuth??>${item.judAuth}</#if></td>
                        <td><#if item.penDecIssDate??>${(item.penDecIssDate?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.auditDate??>${(item.auditDate?string("yyyy年MM月dd日"))!''}</#if></td>
                    </tr>
                        <#if item.pubOtherPunishAlterList??&&(item.pubOtherPunishAlterList?size>0)>
                        <tr>
                            <td colspan="8" class="tip2">
                                <div class="fl">有变更情形：</div>
                                <div class="fl">
                                    <#list item.pubOtherPunishAlterList as item>
                                        <p>${item_index}}、<#if item.judAuth??>${item.judAuth}</#if><#if item.altDate??>${(item.altDate?string("yyyy年MM月dd日"))!''}</#if>
                                            <#if item.contents??>${item.contents}。</#if></p>
                                    </#list>
                                </div>
                            </td>
		                </tr>
                        </#if>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>列入经营异常名录信息
            </h3>
            <table class="table-common table-chufa">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="220">纳入经营异常名录原因</th>
                    <th width="105">列入日期</th>
                    <th width="140">作出决定机关（列入）</th>
                    <th width="250">移出经营异常名录原因</th>
                    <th width="105">移出日期</th>
                    <th>作出决定机关（移出）</th>
                </tr>
                </thead>
                <tbody id="pbopanomaly_listData">
                <#if nomalList?size==0>
                <tr><td colspan="7"><div class="no-con">暂无列入经营异常名录信息 </div></td></tr>
                <#else>
                    <#list nomalList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.speCauseCN??>${item.speCauseCN}</#if></td>
                        <td><#if item.abnTime??>${(item.abnTime?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.decorgCN??>${item.decorgCN}</#if></td>
                        <td><#if item.remExcpresCN??>${item.remExcpresCN}</#if></td>
                        <td><#if item.remDate??>${(item.remDate?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.reDecOrgCN??>${item.reDecOrgCN}</#if></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>列入严重违法失信企业名单（黑名单）信息
            </h3>
            <table class="table-common table-chufa mb20">
                <thead>
                <tr>
                    <th width="35">
                        序号
                    </th>
                    <th width="70">
                        类别
                    </th>
                    <th width="185">
                        列入严重违法失信企业名单（黑名单）原因
                    </th>
                    <th width="115">
                        列入日期
                    </th>
                    <th width="120">
                        作出决定机关（列入）
                    </th>
                    <th width="185">
                        移出严重违法失信企业名单（黑名单）原因
                    </th>
                    <th width="115">
                        移出日期
                    </th>
                    <th>
                        作出决定机关（移出）
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr><td colspan="20"><div class="no-con">暂无列入严重违法失信企业名单（黑名单）信息 </div></td></tr>

                </tbody>
            </table>
        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>抽查检查结果信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="50">序号</th>
                    <th width="290">检查实施机关</th>
                    <th>类型</th>
                    <th width="130">日期</th>
                    <th width="390">结果</th>
                </tr>
                </thead>
                <tbody id="table-pubscresult">
                <#if checkList?size==0>
                <tr><td colspan="5"><div class="no-con">暂无抽查检查结果信息</div></td></tr>
                <#else>
                    <#list checkList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.inspectDesc??> ${item.inspectDesc}
                    </#if></td>
                        <td><#if item.scType??>${item.scType}</#if></td>
                        <td><#if item.inspectDate??> ${item.inspectDate}</#if></td>
                        <td><#if item.remark??>${item.remark}</#if></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>

        </div>

        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>司法协助信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="240">被执行人</th>
                    <th width="120">股权数额</th>
                    <th width="160">执行法院</th>
                    <th width="190">执行通知书文号</th>
                    <th width="130">类型 | 状态</th>
                </tr>
                </thead>
                <tbody id="_justice">
                <#if justList?size==0>
                <tr><td colspan="20"><div class="no-con">暂无司法协助信息</div></td></tr>
                <#else>
                    <#list justList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.inv??>${item.inv}</#if></td>
                        <td><#if item.froAm??>${item.froAm}</#if><#if item.froAuth??>${item.froAuth}</#if></td>
                        <td><#if item.executionCourt??>${item.executionCourt}</#if></td>
                        <td><#if item.executeNo??>${item.executeNo}</#if></td>
                        <td>
                            <#if item.justiceType??>
                                <#if item.justiceType=="1">
                                    股权冻结|
                                    <#if item.frozState??>
                                        <#if item.frozState=="1">
                                            冻结
                                        </#if>
                                        <#if item.frozState=="2">
                                            解除冻结
                                        </#if>
                                        <#if item.frozState=="3">
                                            失效
                                        </#if>  </#if>
                                <#else>
                                    股东变更
                                </#if>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>动产抵押登记信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="120">登记编号</th>
                    <th width="130">登记日期</th>
                    <th width="240">登记机关</th>
                    <th width="150">被担保债权数额</th>
                    <th width="55">状态</th>
                    <th>公示日期</th>
                </tr>
                </thead>
                <tbody>
                <#if (mortList?size==0)>
                <tr><td colspan="20"><div class="no-con">暂无动产抵押登记信息</div></td></tr>
                <#else>
                    <#list mortList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.filingNO??>${item.filingNO}</#if></td>
                        <td><#if item.checkDate??> ${(item.checkDate?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.departMentName??>${item.departMentName}</#if></td>
                        <td><#if item.mortGageAmount??>${item.mortGageAmount} 万元</#if></td>
                        <td>
                            <#if item.cancelStatus??>
                                <#if item.cancelStatus=="0">
                                    有效
                                <#else>
                                    无效
                                </#if>
                            </#if>
                        </td>
                        <td><#if item.checkDate??>${(item.checkDate?string("yyyy年MM月dd日"))!''}</#if></td>
                    </tr>

                    </#list>
                </#if>
                </tbody>
            </table>

        </div>

        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股权出质登记信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="80">登记编号</th>
                    <th width="80">出质人</th>
                    <th width="100">证照/证件号码</th>
                    <th width="100">出质股权数额</th>
                    <th width="100">质权人</th>
                    <th width="100">证照/证件号码</th>
                    <th width="110">股权出质设立登记日期</th>
                    <th width="40">状态</th>
                    <th width="110">公示日期</th>
                </tr>
                </thead>
                <tbody id="_pledge">
                <#if pledgList?size==0>
                <tr><td colspan="20"><div class="no-con">暂无股权出质登记信息</div></td></tr>
                <#else>
                    <#list pledgList as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.orderNO??>${item.orderNO}</#if></td>
                        <td><#if item.pledgor??>${item.pledgor}</#if></td>
                        <td>
                            <#if (item.pledgor?length lt 6) >
                                ( 非公示项 )
                            <#else>
                                <#if item.pleBLicNO??>
                                ${item.pleBLicNO}
                                </#if>
                            </#if>  </td>
                        <td>
                            <#if item.impAm??>
                            <#else>
                            ${item.impAm} 万元
                            </#if>
                        </td>
                        <td>
                            <#if item.impOrg??>${item.impOrg}</#if></td>
                        <td>
                            <#if (item.impOrg?length lt 6) >
                                ( 非公示项 )
                            <#else>
                            ${item.impBLicNO}
                            </#if>

                        </td>
                        <td>
                            <#if item.recDate??>
                         ${(item.recDate?string("yyyy年MM月dd日"))!''} </#if></td>
                        <td>
                            <#if item.status=="K"||item.status=="B">
                                有效
                            <#else>
                                无效
                            </#if>
                        </td>
                        <td>
                            <#if item.equPleDate??>
                        ${(item.equPleDate?string("yyyy年MM月dd日"))!''}</#if></td>
                    </tr>

                    </#list>

                </#if>
                </tbody>
            </table>

        </div>

        <h2>企业自行公示信息<span class="light ml10 font-14 va-top">(企业自行公示信息由该企业提供，企业对其即时信息的真实性、合法性负责)</span></h2>
        <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
            <h3 class="i-title">
                <i></i>股东及出资信息
            </h3>
            <table class="table-common table-gudong-imme table-nest" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="8%">股东</th>
                    <th width="8%">认缴额(万${entBasicInfo.currencyCn})</th>
                    <th width="8%">实缴额(万${entBasicInfo.currencyCn})</th>
                    <th valign="top" width="38%">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table-common">
                            <tr>
                                <td colspan="4">认缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">认缴<br/>出资方式</td>
                                <td width="22%">认缴出资额<br/>（万${entBasicInfo.currencyCn}）</td>
                                <td width="32%">认缴<br/>出资日期</td>
                                <td>公示日期</td>
                            </tr>
                        </table>
                    </th>
                    <th valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%"  class="inner-table-common">
                            <tr>
                                <td colspan="4">实缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">实缴出资方式</td>
                                <td width="22%">实缴出资额<br/>（万${entBasicInfo.currencyCn}）</td>
                                <td width="32%">实缴<br/>出资日期</td>
                                <td>公示日期</td>
                            </tr>
                        </table>
                    </th>
                </tr>
                </thead>   <tbody>
            <#if (invesList?size >0) >
                <#list invesList as item>
                <tr>
                    <td><#if item.inv??> ${item.inv}</#if></td>
                    <td>
                        <#if item.liSubConAm??>
        ${item.liSubConAm}
        </#if>
                    </td>
                    <td>
                        <#if item.liAcConAm??>
        ${item.liAcConAm}
        </#if>
                    </td>
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                            <tbody>
                                <#if (item.imInvprodetailList?size!=0)>
                                    <#list item.imInvprodetailList as item>
                                    <tr>
                                        <td width="28%"><#if item.conFormCN??> ${item.conFormCN}</#if></td>
                                        <td width="22%"><#if item.subConAm??>${item.subConAm}</#if></td>
                                        <td width="32%">
                                            <#if item.conDate??>
        ${(item.conDate?string("yyyy年MM月dd日"))!''}
       </#if>
                                        </td>
                                        <td>
                                            <#if item.publicDate??>
        ${(item.publicDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                    </tr>
                                    </#list>
                                </#if>
                            </tbody>
                        </table>
                    </td>
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                            <tbody>
                                <#if (item.imInvactdetailList?size!=0)>
                                    <#list item.imInvactdetailList as item>
                                    <tr>
                                        <td width="28%"><#if item.acConFormCn??> ${item.acConFormCn}</#if></td>
                                        <td width="22%"><#if item.acConAm??>${item.acConAm}</#if></td>
                                        <td width="32%"><#if item.conDate ??> ${(item.conDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                        <td><#if item.publicDate??>${(item.publicDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                    </tr>
                                    </#list>
                                </#if>

                            </tbody>
                        </table>
                    </td>
                </tr>
                </#list>
            </#if>
            </tbody>
            </table>
        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股权变更信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="80">序号</th>
                    <th width="200">股东</th>
                    <th width="200">变更前股权比例</th>
                    <th width="170">变更后股权比例</th>
                    <th width="150">股权变更日期</th>
                    <th>公示日期</th>
                </tr>
                </thead>
                <tbody id="invsral">
                <#if Ivsralist?size==0>
                <tr><td colspan="20"><div class="no-con">暂无股权变更信息</div></td></tr>
                <#else>
                    <#list Ivsralist as item>
                    <tr>
                        <td>${item_index}</td>
                        <td><#if item.inv??> ${item.inv}</#if></td>
                        <td><#if item.beTransAmPr??>${item.beTransAmPr}%</#if></td>
                        <td><#if item.beTransAmPr??> ${item.afTransAmPr}%</#if></td>
                        <td><#if item.beTransAmPr??> ${(item.equAltDate?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.beTransAmPr??> ${(item.publicDate?string("yyyy年MM月dd日"))!''}</#if></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政许可信息
            </h3>
            <table class="table-common table-xuke mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="130">许可文件编号</th>
                    <th width="120">许可文件名称</th>
                    <th width="110">有效期自</th>
                    <th width="110">有效期至</th>
                    <th width="170">许可机关</th>
                    <th width="140">许可内容</th>
                    <th width="50">状态</th>
                </tr>
                </thead>
                <tbody id="permit">
                <#if (permitlist?size==0)>
                <tr><td colspan="8"><div class="no-con">暂无行政许可信息</div></td></tr>
                <#else>
                    <#list permitlist as item>
                    <tr>
                        <td> ${item_index}</td>
                        <td><#if item.licNO??> ${item.licNO}</#if></td>
                        <td><#if item.licNameCN??>${item.licNameCN}</#if></td>
                        <td><#if item.licNameCN??>${(item.valFrom?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.valTo??> ${(item.valTo?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.licAnth??>${item.licAnth}</#if></td>
                        <td><#if item.licItem??>${item.licItem}</#if></td>
                        <td>
                            <#if item.pubFlag??>
                                <#if item.pubFlag=="1">
                                    公示
                                <#else>
                                    未公示
                                </#if>
                            </#if>
                        </td>
                    </tr>

                    </#list>
                </#if>
                </tbody>
            </table>
        </div>

        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>知识产权出质登记信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="140">知识产权登记证号</th>
                    <th width="80">名称</th>
                    <th width="70">种类</th>
                    <th width="92">出质人名称</th>
                    <th width="92">质权人名称</th>
                    <th width="230">质权登记期限</th>
                    <th width="35">状态</th>
                    <th width="100">公示日期</th>
                </tr>
                </thead>
                <tbody id="ippldg">
                <#if ippldglist?size==0>
                <tr><td colspan="20"><div class="no-con">暂无知识产权出质登记信息</div></td></tr>
                <#else>
                    <#list ippldglist as item>
                    <tr>
                        <td>${item_index}</td>
                        <td>
                            <#if item.TMRegNo??>${item.TMRegNo}</#if>
                        </td>
                        <td> <#if item.TMName??>${item.TMName}</#if></td>
                        <td> <#if item.kinds??>
                            <#if item.kinds=="1">商标
                            <#elseif item.kinds=="2">版权
                            <#elseif item.kinds=="3">专利
                            <#else>
                            ${item.kinds}
                            </#if>
                        </#if></td>
                        <td> <#if item.pledgor??>${item.pledgor}</#if></td>
                        <td> <#if item.impOrg??>${item.impOrg}</#if></td>
                        <td> <#if item.pleRegPerFrom??>${(item.pleRegPerFrom?string("yyyy年MM月dd日"))!''}</#if>-<#if item.pleRegPerTo??>${(item.pleRegPerTo?string("yyyy年MM月dd日"))!''}}</#if></td>
                        <td>
                            <#if item.pubType??>
                            <#else>
                                <#if item.pubType??>
                                    <#if item.pubType=="1">变更</#if>   </#if>
                                <#if item.pubType??>
                                    <#if item.pubType=="2">注销</#if></#if>
                                <#if item.pubType??>
                                    <#if item.pubType=="3">撤销</#if></#if>
                                有效
                            </#if>
                        </td>
                        <td><#if item.publicDate??>${(item.publicDate?string("yyyy年MM月dd日"))!''}</#if></td>
                    </tr> </#list>
                </#if>
                </tbody>
            </table>
        </div>

        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>行政处罚信息
            </h3>
            <table class="table-common table-chufa mb20">
                <thead>
                <tr>
                    <th width="35">序号</th>
                    <th width="155">决定书文号</th>
                    <th width="155">违法行为类型</th>
                    <th width="130">行政处罚内容</th>
                    <th width="155">决定机关名称</th>
                    <th width="110">处罚决定日期</th>
                    <th width="110">公示日期</th>
                    <th>备注</th>
                </tr>
                </thead>
                <tbody id="case">
                <#if caseList?size==0>
                <tr><td colspan="20"><div class="no-con">暂无行政处罚信息</div></td></tr>
                <#else>
                    <#list caseList as item>
                    <tr>
                        <td> ${item_index}</td>
                        <td><#if item.penDecNo??>${item.penDecNo}</#if></td>
                        <td><#if item.illegActType??>${item.illegActType}</#if></td>
                        <td><#if item.illegActType??>${item.penContent}</#if></td>
                        <td><#if item.judAuth??>${item.judAuth}</#if></td>
                        <td><#if item.penDecIssDate??>${(item.penDecIssDate?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td><#if item.publicDate??>${(item.publicDate?string("yyyy年MM月dd日"))!''}</#if></td>
                        <td rowspan="">
                            <#if item.pubType??>
                                <#if item.pubType=="1">变更  </#if>
                                <#if item.pubType=="2">诉讼</#if>
                                <#if item.pubType=="3">复议  </#if>
                            <#else>
                                有效
                            </#if>
                        </td>
                    </tr>
                        <#if item.caslatList?size!=0>
                        <#else>
                        <tr>
                            <td colspan="8" class="tip2">
                                <div class="fl">有变更情形：</div>
                                <div class="fl">

                                    <#list caslatList as item>
                                        <p>${item_index}}.<#if item.altDate??>${(item.altDate?string("yyyy年MM月dd日"))!''}</#if>
                                            <#if item.penAuthName??>${item.penAuthName}</#if>将<#if item.penContent??>${item.penContent}。</#if></p>
                                    </#list>
                                </div>
                            </td>
                        </tr>
                        </#if>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>

    <#list  year_list as baseInfo>
        <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
            <h3 class="i-title fj-title">
                <i></i>${baseInfo.year?replace(",","")}年度报告
            </h3>
        </div>
    <div class="mod-bd-panel_company no-borderlr border-b-gray pb50">
        <h3 class="i-title">
            <i></i>基本信息
        </h3>
    <ul class="encounter-info clearfix">

        <#if entBasicInfo.entTypeCatg=="16"||entBasicInfo.entTypeCatg=="17">
            <li>
                <em>• </em>
                <span class="title">统一社会信用代码/注册号：</span>
                                        <span>

                                            <#if  baseInfo.uniCode??>
                                     ${baseInfo.uniCode }
                                      <#else>
                                                <#if baseInfo.regNO??>
                                                ${baseInfo.regNO }
                                                </#if>
                                            </#if>
							</span>
            </li>
            <li>
                <em>• </em>
                <span class="title">农专社名称：</span>
                <span><#if baseInfo.farSpeArtName??> ${baseInfo.farSpeArtName}</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('email')!=-1>
                        <span class="title light">电子邮件：</span>
                        <span class="title">电子邮件：</span>
                    </#if><#else> <span class="title">电子邮件：</span></#if>
                <span><#if baseInfo.email??>${baseInfo.email}</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('tel')!=-1>
                        <span class="title light">联系电话：</span>
                    <#else>
                        <span class="title ">联系电话：</span>
                    </#if><#else>
                    <span class="title ">联系电话：</span>
                </#if>

                <span><#if baseInfo.tel??>${baseInfo.tel}</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('memNum')!=-1>
                        <span class="title light">成员人数：</span>
                    <#else>
                        <span class="title ">成员人数：</span>
                    </#if> <#else>
                    <span class="title ">成员人数：</span>
                </#if>

                <span><#if baseInfo.memNum??>${baseInfo.memNum}人</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('farnum')!=-1>
                        <span class="title light">成员人数中农民人数：</span>
                    <#else>
                        <span class="title ">成员人数中农民人数：</span>
                    </#if> </#if>
                <span><#if baseInfo.farnum??>${baseInfo.farnum}人</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('annNewMemNum')!=-1>
                        <span class="title light">本年度新增成员人数：</span>
                    <#else>
                        <span class="title ">本年度新增成员人数：</span>
                    </#if> <#else>
                    <span class="title ">本年度新增成员人数：</span>
                </#if>
                <span><#if baseInfo.annNewMemNum??> ${baseInfo.annNewMemNum}人</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('annRedMemNum')!=-1>
                        <span class="title light">本年度退出成员人数：</span>
                    <#else>
                        <span class="title ">本年度退出成员人数：</span>
                    </#if>
                <#else>
                    <span class="title ">本年度退出成员人数：</span>
                </#if>
                <span><#if baseInfo.annRedMemNum??>${baseInfo.annRedMemNum}人</#if></span>
            </li>
            <li>
                <em>• </em>
                <span class="title ">是否有网站或网店：</span>
                                        <span>

                                            <#if baseInfo.ifWebSite == "0">否
                                            <#else>
                                                是
                                            </#if>
						    	</span>
            </li>

        <#elseif entBasicInfo.entTypeCatg=="50">

            <li>
                <em>• </em>
                <span class="title">注册号：</span>
                                        <span>

                                            <#if   baseInfo.uniCode??>
                                        ${baseInfo.uniCode }
                                        <#else>
                                                <#if baseInfo.regNO??>
                                                ${baseInfo.regNO }
                                                </#if>
                                            </#if>


							</span>
            </li>
            <li>
                <em>• </em>
                <span class="title">个体户名称：</span>
                <span><#if baseInfo.traName??>${baseInfo.traName}</#if></span>
            </li>
            <li>
                <em>• </em>
                <span class="title">经营者名称：</span>
                <span><#if baseInfo.name??>${baseInfo.name}</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if  baseInfo.altItem?index_of('tel')!=-1>
                        <span class="title light">经营者联系电话：</span>
                    <#else>
                        <span class="title ">经营者联系电话：</span>
                    </#if>
                <#else>
                    <span class="title ">经营者联系电话：</span>
                </#if>

                <span><#if baseInfo.tel??>${baseInfo.tel}</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('fundAmStr')!=-1>
                        <span class="title light">资金数额：</span>
                    <#else>
                        <span class="title ">资金数额：</span>
                    </#if>
                <#else>
                    <span class="title ">资金数额：</span>
                </#if>

                <span><#if baseInfo.fundAmStr??> ${baseInfo.fundAmStr}</#if></span>
            </li>
            <li>
                <em>• </em>
                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('empNum')!=-1>
                        <span class="title light">从业人数：</span>
                    <#else>
                        <span class="title ">从业人数：</span>
                    </#if>
                <#else>
                    <span class="title ">从业人数：</span>
                </#if>
                <span><#if baseInfo.empNumStr??>${baseInfo.empNumStr}</#if></span>
            </li>
            <li>
                <em>• </em>
                <span class="title ">是否有网站或网店：</span>
                                        <span>

                                            <#if baseInfo.ifWebSite == "0">否<#else>是</#if>
							</span>
            </li>
        <#else>
            <li>
                <em>• </em>
                <span class="title">统一社会信用代码/注册号：</span>
                                        <span>

                                            <#if baseInfo.uniCode??>    <#else>${baseInfo.regNO } </#if>

	                        </span>
            </li>
            <li>
                <em>• </em>
                <span class="title">企业名称：</span>
                <span><#if baseInfo.entName??>${baseInfo.entName}</#if></span>
            </li>
            <#if  '12,14,34,32,22,28,24'?index_of(entBasicInfo.entTypeCatg)!=-1>
                <li>
                    <em>• </em>
                    <span class="title">隶属企业统一社会信用代码/注册号：</span>
                    <span><#if baseInfo.supRegNO??>${baseInfo.supRegNO}</#if></span>
                </li>
                <li>
                    <em>• </em>
                    <span class="title">隶属企业名称：</span>
                    <span><#if baseInfo.supEntname??>${baseInfo.supEntname}</#if></span>
                </li>
            </#if>
            <li>
                <#if baseInfo.altItem??>
                    <em>• </em>
                    <#if baseInfo.altItem?index_of('addr')!=-1>
                        <span class="title light">企业通信地址：</span>
                    <#else>
                        <span class="title ">企业通信地址：</span>

                    </#if>
                <#else>
                    <span class="title ">企业通信地址：</span>
                </#if>

                <span><#if baseInfo.addr??>${baseInfo.addr}</#if></span>
            </li>
            <li>

                <#if baseInfo.altItem??>
                    <#if  baseInfo.altItem?index_of('postalCode')!=-1>
                        <span class="title light">邮政编码：</span>
                    <#else>
                        <span class="title ">邮政编码：</span>
                    </#if>
                <#else>
                    <span class="title ">邮政编码：</span>
                </#if>


                <span><#if baseInfo.postalCode??>${baseInfo.postalCode}</#if></span>
            </li>
            <li>

                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('tel')!=-1>
                        <span class="title light">企业联系电话：</span>
                    <#else>
                        <span class="title ">企业联系电话：</span>
                    </#if>
                <#else>
                    <span class="title ">企业联系电话：</span>
                </#if>

                <span><#if baseInfo.tel??>${baseInfo.tel}</#if></span>
            </li>
            <li>

                <#if baseInfo.altItem??>
                    <#if baseInfo.altItem?index_of('email')!=-1>
                        <span class="title light">企业电子邮箱：</span>
                    <#else>
                        <span class="title ">企业电子邮箱：</span>
                    </#if>
                <#else>
                    <span class="title ">企业电子邮箱：</span>
                </#if>




                <span><#if baseInfo.email??>${baseInfo.email}</#if></span>
            </li>

            <#if '12,14,34,32,22,28,24'?index_of(entBasicInfo.entTypeCatg)!=-1>
                <li>

                    <#if baseInfo.altItem??>
                        <#if baseInfo.altItem?index_of('dom')!=-1>
                            <span class="title light">营业场所：</span>
                        <#else>
                            <span class="title ">营业场所：</span>
                        </#if>
                    <#else>
                        <span class="title ">营业场所：</span>
                    </#if>


                    <span><#if baseInfo.dom??>${baseInfo.dom}</#if></span>
                </li>
                <li>

                    <#if baseInfo.altItem??>
                        <#if baseInfo.altItem?index_of('busStatus')!=-1>
                            <span class="title light">企业经营状态：</span>
                        <#else>
                            <span class="title ">企业经营状态：</span>
                        </#if>
                    <#else>
                        <span class="title">企业经营状态：</span>
                    </#if>
                    <span class="title">企业经营状态：</span>

                    <span><#if baseInfo.busStatusCN??>${baseInfo.busStatusCN}</#if></span>
                </li>
                <li>
                    <#if  baseInfo.altItem??>
                        <#if  baseInfo.altItem?index_of('empNum')!=-1>
                            <span class="title light">从业人数：</span>
                        <#else>
                            <span class="title ">从业人数：</span>

                        </#if> </#if>


                    <span><#if baseInfo.empNumStr??>${baseInfo.empNumStr}</#if></span>
                </li>
                <#if (baseInfo.year > 2015)>
                    <li>

                        <#if baseInfo.altItem??>
                            <#if baseInfo.altItem?index_of('femaleEmploye')!=-1>
                                <span class="title light">其中女性从业人数：</span>
                            <#else>
                                <span class="title ">其中女性从业人数：</span>
                            </#if>   </#if>

                        <span><#if baseInfo.femaleEmployeStr??>${baseInfo.femaleEmployeStr}</#if></span>
                    </li>
                </#if>
                <li>

                    <span class="title">是否有对外担保信息：</span>
                                                <span>

                                                    <#if  baseInfo.ifForguarantee =="0">否
                                                    <#else>
                                                        是
                                                    </#if>
			                        </span>
                </li>
                <li>

                    <span class="title">是否有网站或网店：</span>
                                                <span>

                                                    <#if  (baseInfo.ifWebSite == "0")>否<#else> 是</#if>
									</span>
                </li>
            </#if>

            <li>

                <#if baseInfo.altItem??>
                    <#if  baseInfo.altItem?index_of('empNum')!=-1>
                        <span class="title light">从业人数：</span>
                    <#else>
                        <span class="title ">从业人数：</span>
                    </#if>
                <#else>
                    <span class="title ">从业人数：</span>
                </#if>

                <span><#if baseInfo.empNumStr??>${baseInfo.empNumStr}</#if></span>
            </li>
            <#if baseInfo??>
                <#if (baseInfo.year>2015)>
                    <li>

                        <#if baseInfo.altItem??>
                            <#if  baseInfo.altItem?index_of('femaleEmploye')!=-1>
                                <span class="title light">其中女性从业人数：</span>
                            <#else>
                                <span class="title ">其中女性从业人数：</span>
                            </#if>
                        <#else>
                            <span class="title ">其中女性从业人数：</span>
                        </#if>

                        <span><#if baseInfo.femaleEmployeStr??>${baseInfo.femaleEmployeStr}</#if></span>
                    </li>
                </#if> </#if>

            <li>

                <#if baseInfo.altItem??>
                    <#if  baseInfo.altItem?index_of('busStatus')!=-1>
                        <span class="title light">企业经营状态：</span>
                    <#else>
                        <span class="title ">企业经营状态：</span>
                    </#if>
                <#else>
                    <span class="title ">企业经营状态：</span>
                </#if>




                <span><#if baseInfo.busStatusCN??>${baseInfo.busStatusCN}</#if></span>
            </li>
            <#if baseInfo.year??>
                <#if (baseInfo.year>2015)>
                    <li>

                        <span class="title">企业控股情况：</span>
                                                    <span>

                                           <#if baseInfo.entControlStr=='1'>
                                               国有控股
                                           </#if>
                                                        <#if baseInfo.entControlStr=='2'>
                                                            集体控股
                                                        </#if>
                                                        <#if baseInfo.entControlStr=='3' >
                                                            私人控股
                                                        </#if>
                                                        <#if baseInfo.entControlStr=='4'>
                                                            港澳台商控股
                                                        </#if>
                                                        <#if  baseInfo.entControlStr=='5'  >
                                                            外商控股
                                                        </#if>
                                                        <#if  baseInfo.entControlStr=='6'  >
                                                            其他
                                                        </#if>
                                                        <#if baseInfo.entControlStr??>
                                                        ${baseInfo.entControlStr}
                                                        </#if>

			                        </span>
                    </li>
                </#if> </#if>
            <li>

                <span class="title">是否有投资信息或购买其他公司股权：</span>
                                                <span>

                                                    <#if  (baseInfo.ifForInvest =="0")>否
                                                    <#else>
                                                        是
                                                    </#if>
			                        </span>
            </li>
            <li>

                <span class="title ">是否有网站或网店：</span>
                                                <span>

                                                    <#if  baseInfo.ifWebSite =="0">否
                                                    <#else>
                                                        是
                                                    </#if>
									</span>
            </li>
            <li>

                <span class="title">是否有对外担保信息：</span>
                                                <span>

                                                    <#if (baseInfo.ifForguarantee =="0")>否
                                                    <#else>
                                                        是
                                                    </#if>
			                        </span>
            </li>
            <#if retTpe??>
                <#if  repType?index_of('alterstockinfo')!=-1>
                    <li>

                        <span class="title">有限责任公司本年度是否发生股东股权转让：</span>
                                                    <span>

                                                        <#if  (baseInfo.ifAleErstock == "0")>否
                                                        <#else>
                                                            是
                                                        </#if>
				                        </span>
                    </li>
                </#if> </#if>


            <#if  (baseInfo.year>2015)>
                <li class="item-width">

                    <#if baseInfo.altItem??>
                        <#if  baseInfo.altItem?index_of('entMainBusActivity')!=-1>
                            <span class="title light">企业主营业务活动：</span>
                        </#if>
                    <#else>
                        <span class="title ">企业主营业务活动：</span>
                    </#if>

                    <span><#if baseInfo.entMainBusActivity??>${baseInfo.entMainBusActivity}</#if></span>
                </li>
            </#if>

        </#if>
    </ul>
    </div>

        <#if (entBasicInfo.entTypeCatg=="16"||entBasicInfo.entTypeCatg=="17")>

            <div class="mod-bd-panel_company">

                <#if baseInfo.altTableItem?index_of('SfcWebsiteInfo')!=-1>
                    <h3 class="i-title">
                        <i></i><span class="light">网站或网店信息</span>
                        <span class="number"  ></span>
                    </h3>
                </#if>

                <h3 class="i-title">
                    <i></i>网站或网店信息
                    <span></span>
                </h3>


                <div class="  clearfix">
                    <#if baseInfo.sfcWebList?size!=0>
                        <#list baseInfo.sfcWebList  as item>
                            <div class='item item2'> <div class='title'>
                                <#if item.webSitName??>${item.webSitName}</#if></div> <p>· 类型： <#if item.webType??><#if item.webType=="0">网站<#else>网店</#if></#if></p> <p>· 网址： <#if item.webSite??> ${item.webSite}</#if></p> </div>
                        </#list>
                    </#if>

                </div>
            </div>

            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>生产经营情况信息
                </h3>
                <table class="table-common table-zichan">
                    <tr>
                        <td>营业额或营业收入</td>
                        <td><#if baseInfo.vendIncStr??>${baseInfo.vendIncStr}</#if></td>
                        <td>纳税金额</td>
                        <td><#if baseInfo.ratGroStr??> ${baseInfo.ratGroStr}</#if></td>
                    </tr>
                    <tr>
                        <td>盈余总额</td>
                        <td><#if baseInfo.priYeaProfitStr??>${baseInfo.priYeaProfitStr}</#if></td>
                        <td>获得政府扶持资金、补助</td>
                        <td><#if baseInfo.priYeaSubStr??>${baseInfo.priYeaSubStr}</#if></td>
                    </tr>
                    <tr>
                        <td>金融贷款</td>
                        <td><#if baseInfo.priYeaLoanStr??>${baseInfo.priYeaLoanStr}</#if></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>

            <div class="mod-bd-panel_company">

                <#if  baseInfo.altTableItem?index_of('SfcBranchInfo')!=-1>
                    <h3 class="i-title">
                        <i></i><span class="light">分支机构信息</span>
                    </h3>
                </#if>

                <h3 class="i-title">
                    <i></i>分支机构信息
                </h3>



                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>分支机构统一社会信用码/注册号</th>
                        <th>分支机构名称</th>
                    </tr>
                    </thead>
                    <tbody >
                        <#if (baseInfo.branchList?size==0)>
                        <tr><td  colspan="20"><div class="no-con">暂无分支机构信息</div></td></tr>
                        <#else>
                            <#list baseInfo.branchList as item>
                            <tr>
                                <td><#if item_index??>${item_index}</#if></td>
                                <td><#if item.uniCode??>${item.uniCode}</#if></td>
                                <td><#if item.brName??>${item.brName}</#if></td>
                            </tr>
                            </#list>
                        </#if>
                    </tbody>
                </table>

            </div>


            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>行政许可信息
                </h3>


                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>许可文件中文名称</th>
                        <th>有效期至</th>
                    </tr>
                    </thead>
                    <tbody  >
                        <#if baseInfo.licenceList?size==0>
                        <tr><td  colspan="20"><div class="no-con">暂无行政许可信息</div></td></tr>
                        <#else>
                            <#list baseInfo.licenceList as item>
                            <tr>
                                <td>${item_index}</td>
                                <td><#if item.licNameCN??>${item.licNameCN}</#if></td>
                                <td><#if item.valTo??>${(item.valTo?string("yyyy年MM月dd日"))!''}</#if></td>
                            </tr>

                            </#list>
                        </#if>
                    </tbody>
                </table>

            </div>
        </#if>
        <#if  entBasicInfo.entTypeCatg=="50">

            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>网站或网店信息
                    <span class="number"></span>
                </h3>


                <div class="renyuan-list  clearfix">
                    <#if baseInfo.pbWebsiteList?size!=0>
                        <#list baseInfo.pbWebsiteList as item>
                            <div class='item item2'> <div class='title'><#if item.webSitName??>${item.webSitName}</#if></div>
                                <p>· 类型：<#if item.webType=="0">网站<#else>网店</#if></p> <p>· 网址：<#if item.webSite??>${item.webSite}</#if></p> </div>
                        </#list>
                    </#if>
                </div>
            </div>

            <div class="mod-bd-panel_company">
                <#if baseInfo.altItem??>
                    <#if  baseInfo.altItem?index_of('vendIncIsPub')!=-1||baseInfo.altItem?index_of('ratGroIsPub')!=-1>
                        <h3 class="i-title">
                            <i></i><span class="light">生产经营情况信息</span>
                        </h3>
                    </#if></#if>

                <h3 class="i-title">
                    <i></i>生产经营情况信息
                </h3>


                <table class="table-common table-zichan">
                    <tr>
                        <td>营业额或营业总收入</td>
                        <td><#if baseInfo.vendIncStr??> ${baseInfo.vendIncStr}</#if></td>
                        <td>纳税总额</td>
                        <td><#if baseInfo.ratGroStr??>${baseInfo.ratGroStr}</#if></td>
                    </tr>
                </table>
            </div>

            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>行政许可信息
                </h3>



                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>许可文件中文名称</th>
                        <th>有效期至</th>
                    </tr>
                    </thead>
                    <tbody >
                        <#if baseInfo.pbLicenceList ?size==0>
                        <tr><td  colspan="20"><div class="no-con">暂无行政许可信息</div></td></tr>
                        <#else>
                            <#list baseInfo.pbLicenceList as item>
                            <tr>
                                <td>${item_index}</td>
                                <td><#if item.licNameCN??>${item.licNameCN}</#if></td>
                                <td><#if item.valTo??>${(item.valTo?string("yyyy年MM月dd日"))!''}</#if></td>
                            </tr>
                            </#list>
                        </#if>
                    </tbody>
                </table>

            </div>
        </#if>
        <#if (entBasicInfo.entTypeCatg!="16"&&entBasicInfo.entTypeCatg!="17"&&entBasicInfo.entTypeCatg!="50")>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>网站或网店信息
                    <span class="number" id="website"></span>
                </h3>


                <div class="renyuan-list   clearfix">
                    <#if (baseInfo.webList?size gt 0) >
                        <#list baseInfo.webList as item >
                            <div class='item item2'> <div class='title'><#if item.webSitName??> ${item.webSitName}</#if></div>
                                <p>· 类型：<#if item.webType=="0">网站<#else>网店</#if></p>
                                <p>· 网址：<#if item.webSite??>${item.webSite}</#if></p> </div>
                        </#list>
                    </#if>

                </div>
            </div>

            <#if  baseInfo.repYearType?index_of('subcapital') != -1 >
                <div class="mod-bd-panel_company">
                    <#if baseInfo.altTableItem??>
                        <#if  baseInfo.altTableItem?index_of('Subcapital')!=-1>
                            <h3 class="i-title">
                                <i></i><span class="light">股东及出资信息</span>
                            </h3>
                        </#if></#if>

                    <h3 class="i-title">
                        <i></i>股东及出资信息
                    </h3>


                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>股东</th>
                            <th>认缴出资额(万元)</th>
                            <th>认缴出资时间</th>
                            <th>认缴出资方式</th>
                            <th>实缴出资额(万元)</th>
                            <th>实缴出资时间</th>
                            <th>实缴出资方式</th>
                        </tr>
                        </thead>
                        <tbody  >
                            <#if baseInfo.subcapiList?size==0>
                            <tr><td  colspan="20"><div class="no-con">暂无股东及出资信息</div></td></tr>
                            <#else>
                                <#list baseInfo.subcapiList as item>
                                <tr>
                                    <td>${item_index}</td>
                                    <td><#if item.inv??>${item.inv}</#if></td>
                                    <td><#if item.lisubconam??>${item.lisubconam}</#if></td>
                                    <td><#if item.subConDate??>${(item.subConDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                    <td><#if item.conFormCN??>${item.conFormCN}</#if></td>
                                    <td><#if item.liacconam??>${item.liacconam}</#if></td>
                                    <td><#if  item.acConDate??>${(item.acConDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                    <td><#if item.acConFormCn??>${item.acConFormCn}</#if></td>
                                </tr>

                                </#list>
                            </#if>
                        </tbody>
                    </table>

                </div>

            </#if>

            <#if baseInfo.repYearType?index_of('forinvestment') != -1>
                <div class="mod-bd-panel_company">

                    <#if  baseInfo.altTableItem??>
                        <#if  baseInfo.altTableItem?index_of('ForinvestMent')!=-1>
                            <h3 class="i-title">
                                <i></i><span class="light">对外投资信息</span>
                                <span class="number"  ></span>
                            </h3>
                        </#if>
                    </#if>

                    <h3 class="i-title">
                        <i></i>对外投资信息
                        <span class="number"  ></span>
                    </h3>


                    <div class="renyuan-list  clearfix">
                        <#list baseInfo.forInvesList as item>
                            <div class='item item2'>
                                <div class='title'><#if item.entName??>${item.entName}</#if></div>
                                <p>· 统一社会信用代码/注册号><#if item.uniCode??>：${item.uniCode}</#if></p> </div>

                        </#list>



                    </div>
                </div>
            </#if>


            <#if  baseInfo.repYearType?index_of('asset') != -1 &&  baseInfo.repYearType?index_of('assetbranch') == -1>
                <div class="mod-bd-panel_company">
                    <h3 class="i-title">
                        <i></i>企业资产状况信息
                    </h3>
                    <table class="table-common table-zichan">
                        <tr>
                            <td class="odd">资产总额</td>
                            <td><#if baseInfo.assGroStr??>${baseInfo.assGroStr}</#if></td>
                            <td class="odd">所有者权益合计</td>
                            <td><#if baseInfo.totEquStr??>${baseInfo.totEquStr}</#if></td>
                        </tr>
                        <tr>
                            <td class="odd">营业总收入</td>
                            <td><#if baseInfo.vendIncStr??>${baseInfo.vendIncStr}</#if></td>
                            <td class="odd">利润总额</td>
                            <td><#if baseInfo.proGroStr??>${baseInfo.proGroStr}</#if></td>
                        </tr>
                        <tr>
                            <td class="odd">营业总收入中主营业务收入</td>
                            <td><#if baseInfo.maiBusIncStr??>${baseInfo.maiBusIncStr}</#if></td>
                            <td class="odd">净利润</td>
                            <td><#if baseInfo.netIncStr??>${baseInfo.netIncStr}</#if></td>
                        </tr>
                        <tr>
                            <td class="odd">纳税总额</td>
                            <td><#if baseInfo.ratGroStr??>${baseInfo.ratGroStr}</#if></td>
                            <td class="odd">负债总额</td>
                            <td><#if baseInfo.liaGroStr??>${baseInfo.liaGroStr}</#if></td>
                        </tr>

                    </table>
                </div>
            </#if>

            <div class="mod-bd-panel_company">
                <#if  baseInfo.altTableItem??>
                    <#if  baseInfo.altTableItem?index_of('ForGuaranteeInfo')!=-1>
                        <h3 class="i-title">
                            <i></i><span class="light">对外提供保证担保信息</span>
                        </h3>
                    </#if>  </#if>

                <h3 class="i-title">
                    <i></i>对外提供保证担保信息
                </h3>



                <table class="table-common mb20" id="forguaranteeinfo_div">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>债权人</th>
                        <th>债务人</th>
                        <th>主债权种类</th>
                        <th>主债权数额</th>
                        <th>履行债务的期限</th>
                        <th>保证的期间</th>
                        <th>保证的方式</th>
                    </tr>
                    </thead>
                    <tbody  >
                        <#if baseInfo.forGuarantList?size==0>
                        <tr><td  colspan="20"><div class="no-con">暂无对外提供保证担保信息</div></td></tr>
                        <#else>
                            <#list baseInfo.forGuarantList as item>
                            <tr>
                                <td>${item_index}</td>
                                <td><#if item.more??>${item.more}</#if></td>
                                <td><#if item.mortgagor??>${item.mortgagor}</#if></td>
                                <td><#if item.transKindCN??>${item.transKindCN}</#if></td>
                                <td><#if item.priClaSecAm??>${item.priClaSecAm}</#if></td>
                                <td><#if item.pefPerDate??>${(item.pefPerDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                <td><#if item.guaPeriodCN??>${item.guaPeriodCN}</#if></td>
                                <td><#if item.transTypeCN??>${item.transTypeCN}</#if></td>
                            </tr>

                            </#list>
                        </#if>

                    </tbody>
                </table>

            </div>
            <#if baseInfo.repYearType?index_of('alterstockinfo') != -1>
                <div class="mod-bd-panel_company">
                    <#if baseInfo.altTableItem??>
                        <#if baseInfo.altTableItem?index_of('AlterStockInfo')!=-1>
                            <h3 class="i-title">
                                <i></i><span class="light">股权变更信息</span>
                            </h3>
                        </#if></#if>

                    <h3 class="i-title">
                        <i></i>股权变更信息
                    </h3>


                    <table class="table-common mb20">
                        <thead>
                        <tr>
                            <th width="100">序号</th>
                            <th width="280">股东</th>
                            <th width="210">变更前股权比例</th>
                            <th width="210">变更后股权比例</th>
                            <th>股权变更日期</th>
                        </tr>
                        </thead>
                        <tbody  >
                            <#if (baseInfo.stockInfoList?size==0)>
                            <tr><td  colspan="20"><div class="no-con">暂无股权变更信息</div></td></tr>
                            <#else>
                                <#list baseInfo.stockInfoList as item>
                                <tr>
                                    <td>${item_index}</td>
                                    <td><#if item.inv??>${item.inv}</#if></td>
                                    <td><#if item.beTransAmPr??>${item.beTransAmPr}</#if></td>
                                    <td><#if item.afTransAmPr??>${item.afTransAmPr}</#if></td>
                                    <td><#if item.altDate??>${(item.altDate?string("yyyy年MM月dd日"))!''}</#if></td>
                                </tr>
                                </#list>
                            </#if>
                        </tbody>
                    </table>

                </div>
            </#if>
        </#if>
    </#list>

        <div class="tips" style="padding-bottom:5px">（以上信息仅供参考，具体内容请以国家企业信用信息公示系统查询页面为准）</div>
        <img src="shuiyin.png" />


</div>
</div>

<img src="shuiyin.png" />

</body>
</html>
