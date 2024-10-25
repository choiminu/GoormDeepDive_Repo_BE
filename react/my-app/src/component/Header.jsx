import React from "react";
import "../css/Header.css"

function Header() {
    return (
        <header>
        <nav class="top-nav">
            <a href="#home">Home</a>
            <a href="#categories">Categories</a>
            <a href="#recommended">Recommended</a>
            <a href="#contact">Contact</a>
        </nav>
        </header>
    );
}

export default Header;