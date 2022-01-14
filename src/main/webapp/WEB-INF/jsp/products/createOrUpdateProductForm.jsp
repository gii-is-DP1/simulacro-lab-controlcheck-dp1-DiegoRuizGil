<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">

	<form:form modelAttribute="product" class="form-horizontal" id="add-product-form">
		<petclinic:inputField label="ProductName" name="name"/>
		<span class="help-inline"><form:errors path="name"/></span>
		<petclinic:inputField label="ProductPrice" name="price"/>
		<span class="help-inline"><form:errors path="price"/></span>
		<petclinic:selectField label="ProductType" name="productType" size="${selectSize}" names="${productTypeNames}"/>
		<span class="help-inline"><form:errors path="productType"/></span>
		<button class="btn btn-default" type="submit">Add Product</button>
	</form:form>

</petclinic:layout>