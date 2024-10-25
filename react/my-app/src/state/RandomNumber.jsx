import React, { useState } from "react";

function RandomNumber() {
    const [number, setRandomNumber] = useState(0);

    
    const craeteRandomNumber = () => {
        const randomNumber = Math.floor(Math.random() * 100) + 1;
        setRandomNumber(randomNumber);
    }


    return (
        <div>
            <p>사용자 번호 : {number}</p>
            <button onClick={craeteRandomNumber}>
                클릭
            </button>
        </div>
    );
}

export default RandomNumber;