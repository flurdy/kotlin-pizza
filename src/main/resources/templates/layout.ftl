<#macro mainLayout title="Pizza">
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/styles/pizza.css">
</head>
<body>

    <header>
        <h1><a href="/">Flurdy's Pizzeria</a></h1>
    </header>

    <section>

        <#nested />

    </section>

</body>
</html>
</#macro>
