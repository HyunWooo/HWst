package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hwst.domain.ProductVo;
import java.util.List;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("euc-kr");

      out.write('\r');
      out.write('\n');

	final int ROWSIZE = 6;
   final int BLOCK = 5;

   int pg = 1;
   
   if(request.getParameter("pg")!=null) {
      pg = Integer.parseInt(request.getParameter("pg"));
   }
   
   int start = (pg*ROWSIZE) - (ROWSIZE-1);
   int end = (pg*ROWSIZE);
   
   int allPage = 0;
   
   int startPage = ((pg-1)/BLOCK*BLOCK)+1;
   int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"http://s.011st.com/img/common/icon/favicon.ico\"  type=\"image/x-ico\">\r\n");
      out.write("    <title>현우st</title>\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/price-range.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/main.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"js/html5shiv.js\"></script>\r\n");
      out.write("    <script src=\"js/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->       \r\n");
      out.write("    <!-- <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\"> -->\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("</head><!--/head-->\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<header id=\"header\"><!--header-->\r\n");
      out.write("\t\t<div class=\"header_top\"><!--header_top-->\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"contactinfo\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav nav-pills\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a><i class=\"fa fa-star\"></i> 관리자 문의</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"contact_us.do\"><i class=\"fa fa-phone\"></i> 010-3341-3855</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"contact_us.do\"><i class=\"fa fa-envelope\"></i> gusdn@sk.com</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-6 col-xs-8\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"shop-menu pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <li><a href=\"#\"><i class=\"fa fa-user\"></i> Account</a></li> -->\r\n");
      out.write(" \t\t\t\t\t\t\t\t<!--<li><a href=\"#\"><i class=\"fa fa-star\"></i> Wishlist</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><!--/header_top-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"header-middle\"><!--header-middle-->\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"logo pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"index.do\"><img src=\"images/home/logo.png\" alt=\"\" /></a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- 안쓰는 버튼그룹 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"btn-group pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default dropdown-toggle usa\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tUSA\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Canada</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">UK</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default dropdown-toggle usa\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\tDOLLAR\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Canadian Dollar</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Pound</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"search_box pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"Search\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"mainmenu pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav navbar-nav collapse navbar-collapse\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"index.do\" class=\"active\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\">Shop<i class=\"fa fa-angle-down\"></i></a>\r\n");
      out.write("                                    <ul role=\"menu\" class=\"sub-menu\">\r\n");
      out.write("                                        <li><a href=\"allProductView.do\">Products</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"product_details.jsp\">Product Details</a></li> \r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li> \r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <li class=\"dropdown\"><a href=\"#\">Blog<i class=\"fa fa-angle-down\"></i></a>\r\n");
      out.write("                                    <ul role=\"menu\" class=\"sub-menu\">\r\n");
      out.write("                                        <li><a href=\"blog.jsp\">Blog List</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"blog_single.jsp\">Blog Single</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </li>  -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <li><a href=\"404.jsp\">404</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"contact_us.do\">Contact-us</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div><!--/header-middle-->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- <div class=\"header-bottom\">header-bottom\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"search_box pull-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"Search\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div> --><!--/header-bottom-->\r\n");
      out.write("\t</header><!--/header-->\r\n");
      out.write("\t\r\n");
      out.write("\t<section id=\"advertisement\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<!-- <img src=\"images/product/advertisement.jpg\" alt=\"\" /> -->\r\n");
      out.write("\t\t\t<img src=\"http://i.011st.com/browsing/banner/2015/06/22/11641/2015062209092255388_8674945_1.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"left-sidebar\">\r\n");
      out.write("\t\t\t\t\t\t<h2>Category</h2>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-group category-products\" id=\"accordian\"><!--category-productsr-->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"panel-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#sportswear\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t의류\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"sportswear\" class=\"panel-collapse collapse\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">남성의류 </a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">여성의류 </a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">유아의류 </a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">스포츠용</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"panel-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#mens\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t악세사리\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"mens\" class=\"panel-collapse collapse\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">귀걸이</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">목걸이</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"panel-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#womens\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t디지털\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"womens\" class=\"panel-collapse collapse\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">가전제품</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">컴퓨터</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"panel-title\"><a href=\"#\">기타 잡화</a></h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div><!--/category-products-->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- <div class=\"brands_products\">brands_products\r\n");
      out.write("\t\t\t\t\t\t\t<h2>Brands</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"brands-name\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(50)</span>Acne</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(56)</span>Grüne Erde</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(27)</span>Albiro</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(32)</span>Ronhill</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(5)</span>Oddmolly</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(9)</span>Boudestijn</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"\"> <span class=\"pull-right\">(4)</span>Rösch creative culture</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>/brands_products\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"price-range\">price-range\r\n");
      out.write("\t\t\t\t\t\t\t<h2>Price Range</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"well\">\r\n");
      out.write("\t\t\t\t\t\t\t\t <input type=\"text\" class=\"span2\" value=\"\" data-slider-min=\"0\" data-slider-max=\"600\" data-slider-step=\"5\" data-slider-value=\"[250,450]\" id=\"sl2\" ><br />\r\n");
      out.write("\t\t\t\t\t\t\t\t <b>$ 0</b> <b class=\"pull-right\">$ 600</b>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>/price-range -->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"shipping text-center\"><!--shipping-->\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"http://i.011st.com/ds/2015/06/16/635/495e5851754d0cb0d49924bfe87374da.jpg\" alt=\"\" /><br>\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"http://i.011st.com/ds/2015/06/23/635/3969f1a36b8d710d43466a0f8022f231.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <img src=\"images/home/shipping.jpg\" alt=\"\" /> -->\r\n");
      out.write("\t\t\t\t\t\t</div><!--/shipping-->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-9 padding-right\">\r\n");
      out.write("\t\t\t\t\t<div class=\"features_items\"><!--features_items-->\r\n");
      out.write("\t\t\t\t\t\t<h2 class=\"title text-center\">All New Item</h2>\r\n");
      out.write("\t\t\t\t\t\t");

							List<ProductVo> list = (List<ProductVo>)(session.getAttribute("productList"));
							                               allPage = (int)Math.ceil(list.size()/(double)ROWSIZE);
							                             
							                             if(endPage > allPage) {
							                                endPage = allPage;
							                             }
							                             
							                               int pageNum = 1;
							                               if(request.getParameter("pg") != null){
							                                  if(request.getParameter("pg").equals("0")){
							                                     pageNum = 1;
							                                  }
							                                  else{
							                                     pageNum = Integer.parseInt(request.getParameter("pg"));
							                                  }
							                               }
							                               
							                               ProductVo tempPro = null;
							                               if(list.size()>20){
							                                   for(int i = (pageNum - 1) * 10; i < (pageNum * 10) - 1; i++)
							                                   {
							                                      tempPro = list.get(i);
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"product-image-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"single-products\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"productinfo text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"images/product/product12.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>");
      out.print( tempPro.getBasicPrice() );
      out.write("</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>$");
      out.print( tempPro.getName() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"product-overlay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"overlay-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h2>");
      out.print(tempPro.getBasicPrice() );
      out.write("</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>");
      out.print( tempPro.getName() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t <div class=\"choose\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul class=\"nav nav-pills nav-justified\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t");
 
                                   }} else if(list.size()>7){
                               for(int i = (pageNum - 1) * 9; i < list.size() ; i++)
                               {
                                  tempPro = list.get(i);
                                  
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- 여기까지가 상품 하나부분 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"product-image-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"single-products\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"productinfo text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"images/product/product12.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>");
      out.print( tempPro.getBasicPrice());
      out.write("</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>");
      out.print( tempPro.getName() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"product-overlay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"overlay-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h2>");
      out.print( tempPro.getBasicPrice());
      out.write("</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>");
      out.print( tempPro.getName() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"choose\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul class=\"nav nav-pills nav-justified\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"\"><i class=\"fa fa-plus-square\"></i>Add to compare</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t");
 
                               }}else{
                                  for(int i = (pageNum - 1) * 10; i < list.size() ; i++)
                                  {
                                  tempPro = list.get(i);
                        
      out.write("\r\n");
      out.write("                        <div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"product-image-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"single-products\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"productinfo text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"images/product/");
      out.print( tempPro.getCategoryNo() );
      out.write('/');
      out.print( tempPro.getProductNo() );
      out.write("_1.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>");
      out.print( tempPro.getBasicPrice() );
      out.write("원</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>");
      out.print( tempPro.getName() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>장바구니 담기</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"product-overlay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"overlay-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>");
      out.print( tempPro.getDetails() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h2>");
      out.print( tempPro.getBasicPrice() );
      out.write("원</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>");
      out.print( tempPro.getName() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>장바구니 담기</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t");
 
                               }
                               }
                        
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- <ul class=\"pagination\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"active\"><a href=\"\">1</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">2</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">3</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">&raquo;</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul> -->\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"pagination pagination-lg\">\r\n");
      out.write("                       <li><a href=\"product.do?pg=");
      out.print(startPage-1);
      out.write("\"><!-- <i class=\"fa fa-long-arrow-left\"> --></i>Previous Page</a></li>\r\n");
      out.write("\t\t                  ");

		                     for(int i=startPage; i<= endPage; i++){
		                        if(i==pg){
		                  
      out.write("\r\n");
      out.write("\t\t                           <li class=\"active\"><a href=\"product.do?pg=");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a></li>\r\n");
      out.write("\t\t                  ");

		                        }else{
		                  
      out.write("\r\n");
      out.write("\t\t                           <li><a href=\"product.do?pg=");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a></li>\r\n");
      out.write("\t\t                  ");

		                        }
		                     }
		                  
      out.write("\r\n");
      out.write("\t                   <li><a href=\"product.do?pg=");
      out.print(endPage+1);
      out.write("\">Next Page<!-- <i class=\"fa fa-long-arrow-right\"></i> --></a></li>\r\n");
      out.write("                    </ul><!--/.pagination-->\r\n");
      out.write("\t\t\t\t\t</div><!--features_items-->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t<footer id=\"footer\"><!--Footer-->\r\n");
      out.write("\t\t<div class=\"footer-bottom\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"single-widget\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"pull-left\">Copyright © 2015 HW. All rights reserved.</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</footer><!--/Footer-->\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("    <script src=\"js/jquery.js\"></script>\r\n");
      out.write("\t<script src=\"js/price-range.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery.scrollUp.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery.prettyPhoto.js\"></script>\r\n");
      out.write("    <script src=\"js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /product.jsp(75,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.userLoginInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"cart.jsp\"><i class=\"fa fa-shopping-cart\"></i> Cart</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<li><a href= \"userManagement.do\"><i class=\"fa fa-user\"></i>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userLoginInfo.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("님</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"logoutProcess.do\"><i class=\"fa fa-crosshairs\"></i> Logout</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"chooseSignup.do\"><i class=\"fa fa-pencil\"></i> Sign Up</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"login.do\"><i class=\"fa fa-lock\"></i> Login</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
