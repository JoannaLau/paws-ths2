/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.15
 * Generated at: 2017-07-26 04:40:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class infographics_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/Keith/Desktop/paws/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/PAWS/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1500738660093L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html class=\"no-js\" lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("     \t <!-- IMPORTS -->\r\n");
      out.write("    <script src='js/jquery.min.js'></script>\r\n");
      out.write("\t\r\n");
      out.write("    <script src='js/jquery-ui.min.js'></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/vendor.css\">\r\n");
      out.write("   \r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\" css/dataTables.bootstrap.min.css\">\r\n");
      out.write("\t<script src=\"js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/dataTables.bootstrap.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write(" \t<link title=\"timeline-styles\" rel=\"stylesheet\" href=\"css/timeline.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- END IMPORTS -->\r\n");
      out.write("    \t\r\n");
      out.write("    \t\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title> PAASCU - Accreditation Schedule Manager </title>\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\r\n");
      out.write("        <!-- Place favicon.ico in the root directory -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/vendor.css\">\r\n");
      out.write("        <!-- Theme initialization -->\r\n");
      out.write("        <script>\r\n");
      out.write("            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :\r\n");
      out.write("            {};\r\n");
      out.write("            var themeName = themeSettings.themeName || '';\r\n");
      out.write("            if (themeName)\r\n");
      out.write("            {\r\n");
      out.write("                document.write('<link rel=\"stylesheet\" id=\"theme-style\" href=\"css/app-' + themeName + '.css\">');\r\n");
      out.write("            }\r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("                document.write('<link rel=\"stylesheet\" id=\"theme-style\" href=\"css/app.css\">');\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\t\t\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("      \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/loader.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("      google.charts.load('current', {'packages':['corechart']});\r\n");
      out.write("      google.charts.setOnLoadCallback(drawChart);\r\n");
      out.write("\r\n");
      out.write("      function drawChart() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar Year = new Array();\r\n");
      out.write("\t\tvar Tertiary = new Array();\r\n");
      out.write("\t\tvar GradSchool = new Array();\r\n");
      out.write("\r\n");
      out.write("\t\tvar Combined = new Array();\r\n");
      out.write("\t\tCombined[0] = ['Year', 'Tertiary', 'Grad School'];\r\n");
      out.write("\t\tYear = ['2009', '2010', '2011', '2012', '2013', '2014'];\r\n");
      out.write("\t\tTertiary = [88, 78, 92, 109, 123, 125];\r\n");
      out.write("\t\tGradSchool = [25, 23, 18, 25, 12, 11];\r\n");
      out.write("\r\n");
      out.write("\t\tfor (var i = 0; i < Year.length; i++){\r\n");
      out.write("\t\t  Combined[i + 1] = [ Year[i], Tertiary[i], GradSchool[i] ];\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        var data = google.visualization.arrayToDataTable(Combined);\r\n");
      out.write("\r\n");
      out.write("        var options = {\r\n");
      out.write("          title: 'Candidate Schools',\r\n");
      out.write("          curveType: 'function',\r\n");
      out.write("          legend: { position: 'bottom' }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));\r\n");
      out.write("\r\n");
      out.write("        chart.draw(data, options);\r\n");
      out.write("      }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("      google.charts.load('current', {'packages':['bar']});\r\n");
      out.write("      google.charts.setOnLoadCallback(drawChart);\r\n");
      out.write("\r\n");
      out.write("\t\tvar YearBar = new Array();\r\n");
      out.write("\t\tvar GradeSchoolBar = new Array();\r\n");
      out.write("\t\tvar HighSchoolBar = new Array();\r\n");
      out.write("\t\tvar BasicBar = new Array();\r\n");
      out.write("\t\tvar TertiaryBar = new Array();\r\n");
      out.write("\t\tvar GradSchoolBar = new Array();\r\n");
      out.write("\t\tvar MedBar = new Array();\r\n");
      out.write("\r\n");
      out.write("\t\tvar CombinedBar = new Array();\r\n");
      out.write("\t\tCombinedBar[0] = ['Year', 'Grade School', 'High School', 'Basic Education', 'Tertiary', 'Graduate School', 'Medical School'];\r\n");
      out.write("\t\tYearBar = ['2009', '2010', '2011', '2012', '2013', '2014'];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tGradeSchoolBar = \t[14, \t9, \t13, 10, 9, 6];\r\n");
      out.write("\t\tHighSchoolBar = \t[15, \t11, 14, 9, \t10, 3];\r\n");
      out.write("\t\tBasicBar = \t\t\t[2, \t12, 14, 12, 15, 17];\r\n");
      out.write("\t\tTertiaryBar = \t\t[50, \t32, 35, 41, 45, 46];\r\n");
      out.write("\t\tGradSchoolBar = \t[8, \t6, \t5, \t6, \t5, 5];\r\n");
      out.write("\t\tMedBar = \t\t\t[4, \t4, \t2, \t2, \t3, 4];\r\n");
      out.write("\r\n");
      out.write("\t\tfor (var j = 0; j < YearBar.length; j++){\r\n");
      out.write("\t\t  CombinedBar[j + 1] = [ YearBar[j], GradeSchoolBar[j], HighSchoolBar[j], BasicBar[j], TertiaryBar[j], GradSchoolBar[j], MedBar[j] ];\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tfor (var x = 0; x < YearBar.length; x++){\r\n");
      out.write("\t\t  console.log(CombinedBar[x]);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      function drawChart() {\r\n");
      out.write("        var data = google.visualization.arrayToDataTable(CombinedBar);\r\n");
      out.write("\r\n");
      out.write("        var options = {\r\n");
      out.write("          chart: {\r\n");
      out.write("            title: 'Candidate Schools',\r\n");
      out.write("            subtitle: '',\r\n");
      out.write("          },\r\n");
      out.write("          bars: 'vertical', // Required for Material Bar Charts.\r\n");
      out.write("          hAxis: {format: 'decimal'},\r\n");
      out.write("          height: 400,\r\n");
      out.write("          colors: ['#1b9e77', '#d95f02', '#7570b3']\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var chart = new google.charts.Bar(document.getElementById('chart_div'));\r\n");
      out.write("\r\n");
      out.write("        chart.draw(data, google.charts.Bar.convertOptions(options));\r\n");
      out.write("\r\n");
      out.write("        var btns = document.getElementById('btn-group');\r\n");
      out.write("\r\n");
      out.write("        // btns.onclick = function (e) {\r\n");
      out.write("\r\n");
      out.write("        //   if (e.target.tagName === 'BUTTON') {\r\n");
      out.write("        //     options.hAxis.format = e.target.id === 'none' ? '' : e.target.id;\r\n");
      out.write("        //     chart.draw(data, google.charts.Bar.convertOptions(options));\r\n");
      out.write("        //   }\r\n");
      out.write("        // }\r\n");
      out.write("      }\r\n");
      out.write("    </script>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\t#contenthole{\r\n");
      out.write("\t\t-webkit-box-shadow: 0px 4px 13px -4px rgba(0,0,0,0.5);\r\n");
      out.write("\t\t-moz-box-shadow: 0px 4px 13px -4px rgba(0,0,0,0.5);\r\n");
      out.write("\t\tbox-shadow: 0px 4px 13px -4px rgba(0,0,0,0.5);\r\n");
      out.write("\t\tpadding:10px;\r\n");
      out.write("\t\tbackground-color: #f8f8f8;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t#smarttable th, #smarttable td {\t\t\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\ttext-overflow: ellipsis;\r\n");
      out.write("\t\twhite-space: nowrap;\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#smarttable th{\r\n");
      out.write("\t\r\n");
      out.write("\t\tcolor:#3c4731;\r\n");
      out.write("\t\tfont-size:110%;\t\t}\r\n");
      out.write("\r\n");
      out.write("\t#smarttable td{\r\n");
      out.write("\t\tpadding:15px;\r\n");
      out.write("\t\tpadding-left:10px;\r\n");
      out.write("\t\tborder: none;\r\n");
      out.write("\t\tcolor:#3c4731;\t\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t#smarttable tr:nth-child(even){\r\n");
      out.write("\t\tbackground-color:#e6f2da;}\r\n");
      out.write("\t\r\n");
      out.write("\t.container{\r\n");
      out.write("\t\twidth: 125%;\r\n");
      out.write("\t\toverflow:hidden;\r\n");
      out.write("\t\tdisplay:block;\r\n");
      out.write("\t\theight: 130px;\r\n");
      out.write("\t\tz-index:-1;\r\n");
      out.write("\t\tmargin-left:-15px;}\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t#bgvid{\r\n");
      out.write("\t\tposition:relative;\r\n");
      out.write("\t\ttop:-400px;\r\n");
      out.write("\t\tmargin-top:0px;\r\n");
      out.write("\t\twidth:115%\t}\r\n");
      out.write("\r\n");
      out.write("\tbody {\t\t\r\n");
      out.write("\t\tfont-family: \"Lucida Grande\",Helvetica,Arial,Verdana,sans-serif;\r\n");
      out.write("\t\tfont-size: 14px;\t}\r\n");
      out.write("\r\n");
      out.write("\t#calendar {\r\n");
      out.write("\t\tmax-width: 900px;\r\n");
      out.write("\t\tmargin: 0 auto;\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#bg{\r\n");
      out.write("\t\theight: 640px;\r\n");
      out.write("\t\tposition:fixed;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#main{\r\n");
      out.write("\t\tposition:relative;\r\n");
      out.write("\t\ttop:-290px;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#pnum_danger,#pnum_info,#pnum_warning,#pnum_primary{\r\n");
      out.write("\t\tfont-size:75px; \r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tmargin-left: -2px;\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tline-height:85px;\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#pnum_danger{\r\n");
      out.write("\tcolor:#ff2b2b;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#pnum_warning{\r\n");
      out.write("\t\tcolor:#fe8832;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#pnum_info{\r\n");
      out.write("\t\tcolor:#5ecdf3;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#pnum_primary{\r\n");
      out.write("\t\tcolor:#85CE36;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#psub{\r\n");
      out.write("\t\tfont-size:17px; \r\n");
      out.write("\t\tcolor:#bcbcbc;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tmargin-top: 6px;\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t\tline-height:20px;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#bc {\r\n");
      out.write("\t\tcolor:white;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#bc:hover { \r\n");
      out.write("\t\tcolor:#85CE36;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#welcome{\r\n");
      out.write("\t\tposition:relative;\r\n");
      out.write("\t\ttop:-65px;\r\n");
      out.write("\t\tcolor:white;\r\n");
      out.write("\t\tleft:20px;\r\n");
      out.write("\t\tfont-family:Existence-Light;\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t.h1{\r\n");
      out.write("\t\tfont-size:100%;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t@font-face {\r\n");
      out.write("\t\tfont-family: Existence-Light;\r\n");
      out.write("\t\tsrc: url(fonts/Roboto-Thin.ttf);}\r\n");
      out.write("\t\t\r\n");
      out.write("\t@font-face {\r\n");
      out.write("\t\tfont-family: Existence-Medium;\r\n");
      out.write("\t\tsrc: url(fonts/Roboto-Regular.ttf);\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t#notifcard{\r\n");
      out.write("\t\t-webkit-box-shadow: 0px 1px 5px 0px rgba(50, 50, 50, 0.58);\r\n");
      out.write("\t\t-moz-box-shadow:    0px 1px 5px 0px rgba(50, 50, 50, 0.58);\r\n");
      out.write("\t\tbox-shadow:         0px 1px 5px 0px rgba(50, 50, 50, 0.58);\r\n");
      out.write("\t\twidth:87%;\r\n");
      out.write("\t\tleft:15px;\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#customheader{\r\n");
      out.write("\t\toverflow:hidden;\r\n");
      out.write("\t\ttop:122px;  \r\n");
      out.write("\t\theight:10px; \r\n");
      out.write("\t\t-webkit-box-shadow: 0px 2px 6px 2px rgba(50, 50, 50, 0.58);\r\n");
      out.write("\t\t-moz-box-shadow:    0px 2px 6px 2px rgba(50, 50, 50, 0.58);\r\n");
      out.write("\t\tbox-shadow:         0px 2px 7px 2px rgba(50, 50, 50, 0.58); \r\n");
      out.write("\t\tfont-family:Existence-Medium;\r\n");
      out.write("\t\tcolor:#f4f4f4;\r\n");
      out.write("\t\tfont-size:90%;\r\n");
      out.write("\t\t/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#e2e2e2+0,dbdbdb+50,d1d1d1+51,fefefe+100;Grey+Gloss+%231 */\r\n");
      out.write("\t\tbackground: rgb(226,226,226); /* Old browsers */\r\n");
      out.write("\t\tbackground: -moz-linear-gradient(top,  rgba(226,226,226,1) 0%, rgba(219,219,219,1) 50%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%); /* FF3.6-15 */\r\n");
      out.write("\t\tbackground: -webkit-linear-gradient(top,  rgba(226,226,226,1) 0%,rgba(219,219,219,1) 50%,rgba(209,209,209,1) 51%,rgba(254,254,254,1) 100%); /* Chrome10-25,Safari5.1-6 */\r\n");
      out.write("\t\tbackground: linear-gradient(to bottom,  rgba(226,226,226,1) 0%,rgba(219,219,219,1) 50%,rgba(209,209,209,1) 51%,rgba(254,254,254,1) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */\r\n");
      out.write("\t\tfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#fefefe',GradientType=0 ); /* IE6-9 */\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#customheader h2{\r\n");
      out.write("\tcolor:black;\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t#maincard{\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t\tpadding:0px;\r\n");
      out.write("\t\tbackground-color: #ffffff;\r\n");
      out.write("\t\ttop:-50px;\r\n");
      out.write("\t\tmargin-bottom: 10px;\r\n");
      out.write("\t\tmargin-top: 0px;\r\n");
      out.write("\t\theight:700px;\r\n");
      out.write("\t\tborder-radius: 3px;\r\n");
      out.write("\t   \r\n");
      out.write("\t\t-webkit-box-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);\r\n");
      out.write("\t\t-moz-box-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);\r\n");
      out.write("\t\tbox-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);\t}\r\n");
      out.write("\t\t\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tj$ = jQuery.noConflict();\r\n");
      out.write("\tj$(document).ready( function () {\r\n");
      out.write("\t\tvar contactTable = j$('[id$=\"smarttable\"]').DataTable({\r\n");
      out.write("\t\t\torder: [[1, 'asc']],\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main-wrapper\">\r\n");
      out.write("            <div class=\"app\" id=\"app\">\r\n");
      out.write("               \r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("\t<video poster=\"assets/banner.jpg\" id=\"bgvid\"  playsinline autoplay muted loop>\r\n");
      out.write("  <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the \"Pause\" button  -->\r\n");
      out.write("\r\n");
      out.write("<source src=\"assets/vid.mp4\" type=\"video/mp4\">\r\n");
      out.write("</video>\r\n");
      out.write("</div>\r\n");
      out.write("            <div id=\"welcome\">\r\n");
      out.write("\t\t\t<h1>Infographics</h1>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                   \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("                <article class=\"content dashboard-page\"  >\r\n");
      out.write("                    <section class=\"section\" style=\"position: relative; top:-135px; left:-25px; width:105%;\" >\r\n");
      out.write("                       <div class=\"table-responsive\" style=\"width:100%; float:right;\" id=\"contenthole\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("              <center>             \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                               <div id=\"curve_chart\" style=\"width: 900px; height: 500px\"></div> <br><br>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div>\r\n");
      out.write("\r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("               </center>            \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                           \r\n");
      out.write("                                            </div>\r\n");
      out.write("                             \r\n");
      out.write("                    </section>\r\n");
      out.write("                </article>\r\n");
      out.write("             \r\n");
      out.write("             </div></div>\r\n");
      out.write("        <!-- Reference block for JS -->\r\n");
      out.write("        <div class=\"ref\" id=\"ref\">\r\n");
      out.write("            <div class=\"color-primary\"></div>\r\n");
      out.write("            <div class=\"chart\">\r\n");
      out.write("                <div class=\"color-primary\"></div>\r\n");
      out.write("                <div class=\"color-secondary\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("          \r\n");
      out.write("        <script src=\"js/app.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
