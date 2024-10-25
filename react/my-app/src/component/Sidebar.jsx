import React from "react";
import "../css/Sidebar.css"

function SideBar() {
    return (
        <section id="categories" class="category-menu">
        <h2>Categories</h2>
        <ul>
            <li><a href="#category1">Technology</a></li>
            <li><a href="#category2">Health</a></li>
            <li><a href="#category3">Lifestyle</a></li>
            <li><a href="#category4">Education</a></li>
        </ul>
        </section>
    );
}

export default SideBar;