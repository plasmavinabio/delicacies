<div xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:jsp="http://java.sun.com/JSP/Page">
<table border="1">
  <tr>
    <th>ID</th>
    <th>Language code</th>
    <th>Language name</th>
  </tr>
  <c:forEach  items="${listLanguages}" var ="language">
  <tr>
    <td>A${language.id}</td>
    <td>B${language.code}</td>
    <td>C${language.name}</td>
  </tr>
  <c:out value="${language.code}
  </c:forEach>
</table>
<c:forEech items="${listTest}" var="kkk">
  <c:out value="${kkk}
</c:forEach>
</div>