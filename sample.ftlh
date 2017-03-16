<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Our latest product:<a href="${url}">${name}</a>!</p>
  <p>${date?string("yyyy/MM/dd")}</p>

</body>
</html>