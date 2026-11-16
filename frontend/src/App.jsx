import { useState, useEffect } from "react";
import CardItem from "./CardItem";

function App(){
  const [cards, setCards] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(()=>{
    
    async function fetchCards(){
      try{
        const res = await fetch("http://localhost:8080/api/cards");

        if(!res.ok) throw new Error("Couldn't load cards.")

        const data = await res.json();

        setCards(data);


      }catch(err){
        setError(err.message);
      }finally{
        setLoading(false);
      }
    }
    fetchCards();
    
  },[])

  async function toggleFreeze(card){
    const action = card.status === "FROZEN" ? "unfreeze" : "freeze";
    const res = await fetch(`http://localhost:8080/api/cards/${card.id}/${action}`, { method: "PATCH" });

    const updated = await res.json();

    setCards(cards.map((c) => (c.id === updated.id ? updated : c)));
  }

  if (loading) return <p>Loading cards...</p>;

  if (error) return <p>Error: {error}</p>;

  return (
  <div>
    <h1>My Cards</h1>
    <ul>
      {cards.map((card) => (
        <CardItem key = {card.id} card={card} onToggleFreeze={toggleFreeze}/> 
      ))}
    </ul>
  </div>

    
  );
}

export default App;