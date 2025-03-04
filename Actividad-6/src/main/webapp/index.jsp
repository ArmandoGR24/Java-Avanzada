<%@ taglib uri="http://www.codigomaestro.com/tags" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Tags Example</title>
</head>
<body>
<custom:welcome />
<br/>
<custom:uppercase>
    <%= request.getAttribute("message") %>
</custom:uppercase>
</body>
</html>
