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
<div id="productcomparelist" class="screenlet">
  <div class="screenlet-title-bar">
    <ul>
      <li class="h3">${uiLabelMap.ProductCompareProducts}</li>
    </ul>
    <br class="clear"/>
  </div>
  <div class="screenlet-body">
  <#assign productCompareList = Static["org.apache.ofbiz.product.product.ProductEvents"].getProductCompareList(request)/>
  <#if productCompareList?has_content>
    <table>
    <#list productCompareList as product>
      <tr>
        <td>
          ${Static["org.apache.ofbiz.product.product.ProductContentWrapper"].getProductContentAsText(product, "PRODUCT_NAME", request, "html")}
        </td>
        <td>
          <form method="post" action="<@ofbizUrl>removeFromCompare</@ofbizUrl>" name="removeFromCompare${product_index}form">
            <input type="hidden" name="productId" value="${product.productId}"/>
          </form>
          <a href="javascript:document.removeFromCompare${product_index}form.submit()" class="buttontext">${uiLabelMap.CommonRemove}</a>
        </td>
      </tr>
    </#list>
  </table>
  <div>
    <a href="<@ofbizUrl>clearCompareList</@ofbizUrl>" class="buttontext">${uiLabelMap.CommonClearAll}</a>
  </div>
  <div>
    <a href="javascript:popUp('<@ofbizUrl secure="${request.isSecure()?string}">compareProducts</@ofbizUrl>', 'compareProducts', '650', '750')" class="buttontext">${uiLabelMap.ProductCompareProducts}</a>
  </div>
<#else>
  <div>
    ${uiLabelMap.ProductNoProductsToCompare}
  </div>
</#if>
  </div>
</div>