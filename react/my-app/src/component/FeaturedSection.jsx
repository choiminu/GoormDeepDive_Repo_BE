import React from "react";
import "../css/FeaturedSection.css"

function FeaturedSection() {
    return(
        <section id="recommended" class="recommended-content">
        <h2>Recommended for You</h2>
        <div class="content">
            <article>
            <h3>Top 10 Tech Trends</h3>
            <p>A brief overview of the latest tech trends you should know.</p>
            </article>
            <article>
            <h3>Healthy Living Tips</h3>
            <p>Easy and effective tips for a healthier lifestyle.</p>
            </article>
            <article>
            <h3>Study Hacks</h3>
            <p>Maximize your learning potential with these study hacks.</p>
            </article>
        </div>
        </section>
    );
}

export default FeaturedSection;