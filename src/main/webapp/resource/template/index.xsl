<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : index.xsl
    Created on : 2019年4月16日, 下午 5:38
    Author     : COSH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
        <xsl:output method="html"/>
        <xsl:template match="/">
                <html>
                        <head>
                                <title>index.xsl</title>
                                <link type="text/css" rel="stylesheet" href="/css/test.css"></link>
                        </head>
                        <p>大貓圖</p>
                        <img src="/image/CAT.jpg"/>
                        <body>
                        </body>
                </html>
        </xsl:template>

</xsl:stylesheet>
