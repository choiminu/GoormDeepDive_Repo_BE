import React from "react";

function JSXPractice() {
    const name = "구름톤 최민우";
    const isLoggedIn = false;
    const numbers = [1, 2, 3, 4, ,5];

    function handleClick() {
        alert("버튼 클릭");
    }

    function getGreeting(user) {
        if (user) {
            return <h2>Hello, {user}!</h2>
        }

        return <h2>Hello, Stranger.</h2>
    }

    return (
        <div>
            <h1>JXS 실습</h1>
            <p>Welcolme, {name}!</p>

            {isLoggedIn ? <p>로그인 되었습니다.</p> : <p>로그인 해주세요.</p>}

            <ul>
                {numbers.map((number) => ( 
                   <li key={number}>{number}</li> 
                ))}
            </ul>


            <button onClick={handleClick}> Click Me</button>

            {getGreeting("민우님")}
            {getGreeting()}

            <h1>{<script>alert("Hacked!")</script>}ㅇㅇ</h1>
        </div>
    );
}

export default JSXPractice;