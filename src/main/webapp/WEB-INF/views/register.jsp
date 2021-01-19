<%--
  Created by IntelliJ IDEA.
  User: wiega
  Date: 19/01/2021
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="menu.jsp"%>
    <div class="container flex justify-center  mt-40 mx-auto ">
        <form class="bg-blue-300 p-4 shadow-2xl">
            <div class="p-3">
                <input class="bg-gray-200 focus:bg-white outline-none py-2 px-4 block w-full" type="email" placeholder="Username">
            </div>
            <div class="p-3">
                <input type="text" placeholder="Password" class="bg-gray-200 focus:bg-white outline-none py-2 px-4 block w-full">
            </div>
            <div class="p-3">
                <input type="text" placeholder="Repeat Password" class="bg-gray-200 focus:bg-white outline-none py-2 px-4 block w-full">
            </div>
            <div class="p-3">
                <button class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">
                    Register
                </button>
            </div>
        </form>
    </div>
</body>
</html>
