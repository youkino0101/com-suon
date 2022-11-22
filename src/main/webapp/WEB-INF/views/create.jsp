<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<%@include file="include/link.jsp"%>
</head>
<body>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6 frm" style="margin-top: 70px;">
			<form:form action="saveCustomer" method="post"
				modelAttribute="customer">
				<form:hidden path="id" cssClass="form-control" />
				<div class="card">
					<div class="card-title text-center">
						<h3 class="title-card__new">THÊM MỚI HỌA SĨ</h3>
						<hr style="height: 1px;">
					</div>
					<div class="card-body">
						<div class="mb-3">
							<form:label path="fullName">Họ và tên:</form:label>
							<form:input path="fullName" cssClass="form-control"
								id="exampleFormControlInput1" />
							<form:errors path="fullName" cssClass="error-message" />

						</div>
						
						<div class="mb-3">
							<form:label path="email">Email:</form:label>
							<form:input path="email" cssClass="form-control"
								id="exampleFormControlInput1" />
							<form:errors path="email" cssClass="error-message" />

						</div>
						<div class="mb-3">
							<form:label path="phone">Số điện thoại:</form:label>
							<form:input path="phone" cssClass="form-control"
								id="exampleFormControlInput1" />
							<form:errors path="phone" cssClass="error-message" />

						</div>
						
						<div class="mb-3">
							<label for="typeCustomer" class="col-md-3 control-label">Loại Khách Hàng: </label>
							<form:select path="typeCustomer" class="form-select" required="required">
								<form:option value="" label="-- Chọn --" />
								<c:forEach var="tp" items="${typeCustomer}">
									<form:option value="${tp.id}" label="${tp.name}"
										selected="${tp.id==customer.typeCustomer.id?'selected':''}" />
								</c:forEach>
							</form:select>

						</div>
						<form:button class="btn btn-outline-info" type="submit">
							<i class="fas fa-user-plus"></i> Thêm mới
						</form:button>
						<a href="/jpaFinal/" class="btn btn-outline-warning"><i
							class="fas fa-home"></i> Trở về trang chủ</a>
					</div>
				</div>
			</form:form>
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>