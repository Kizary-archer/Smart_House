<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new city</title>
</head>

<body>
<div>
    <div>
        <div>
            <h2>Add city </h2>
            <%
                if (request.getAttribute("cityName") != null) {
                    out.println("<p>город '" + request.getAttribute("cityName") + "' added!</p>");
                }
            %>
        </div>

        <form method="post">
            <label>Name:
                <input type="text" name="cityName"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>