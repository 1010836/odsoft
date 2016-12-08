<#--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

<#assign docLangAttr = locale.toString()?replace("_", "-")>
<#assign langDir = "ltr">
<#if "ar.iw"?contains(docLangAttr?substring(0, 2))><#assign langDir = "rtl"></#if>

<html lang="${docLangAttr}" dir="${langDir}" xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  </head>

  <body>
    <style>
        .txf {
            mso-number-format: \@
        } <#-- Text format-->

        .cf {
            mso-number-format: "\#\#0.00"
        } <#-- currency format-->

        .nf {
            mso-number-format: "0.00"
        } <#-- number format-->

        .tf {
            mso-number-format: "HH:mm:ss"
        } <#-- time format-->

        .df {
            mso-number-format: "yyyy-MM-dd"
        } <#-- date format-->

        .dtf {
            mso-number-format: "yyyy-MM-dd HH:mm:ss"
        } <#-- date-time format-->
    </style>
    ${sections.render("body")}
  </body>
</html>
