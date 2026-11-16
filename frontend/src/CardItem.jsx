function CardItem({ card,onToggleFreeze }){
    return (
        <li>
          {card.brand} {card.maskedNumber} - {card.status}
          <button onClick={() => onToggleFreeze(card)}>
            {card.status === "FROZEN" ? "Unfreeze" : "Freeze"}
          </button>
        </li>
    );
}

export default CardItem;    