<#import "layout.ftl" as layout />

<@layout.mainLayout title="Pizza Menu">

<h3>
    Pizza Menu
</h3>

<#if error??>
    <p style="color:red;">${error}</p>
</#if>
<#if orderState??>
    <p style="color:green;">${orderState}</p>
</#if>

<ul>
    <li>
        <form action="/order" method="post">
           <input type="hidden" name="pizza-id" value="1" />
            <div class="pizza-name">
                Margherita
            </div>
            <div class="pizza-order">
                <button type="submit">order</button>
            </div>
        </form>
    </li>
    <li>
        <form action="/order" method="post">
           <input type="hidden" name="pizza-id" value="2" />
            <div class="pizza-name">
                Pepperoni
            </div>
            <div class="pizza-order">
                <button type="submit">order</button>
            </div>
        </form>
    </li>
    <li>
        <form action="/order" method="post">
            <div class="pizza-name">
                Hawaii
            </div>
            <div class="pizza-order">
                <button type="submit">order</button>
            </div>
        </form>
    </li>
</ul>

</@layout.mainLayout>
