import React from 'react';
import ImageOfAgi from '../assets/myagiii.jpg';
import './HomePage.css';

export default function HomePage() {

  async function getData () {
    let response = await fetch('http://localhost:8080/').then(response => response);
    console.log(response);
    return (0)
  }

  getData()

  return (
    <div className='homeContainer'>
      <h1>
          Why are you so pretty? nope!!!!
      </h1>
      <img src={ImageOfAgi} alt="My Agi" />
    </div>
  );
}