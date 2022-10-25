import { useAppContext } from "../context/AppContext";
import styles from "../styles/Letter.module.scss";

const Letter = () => {
  // UseContext when using useReducer
  const { state, dispatch } = useAppContext();
  const handleClick = (e) => {
    e.preventDefault();
    dispatch({ type: "letter", value: e.target.innerText });
  }

  return (
    <div onClick={handleClick} className={styles.letters}>
      <p className={styles.letter}>All</p>
      <p className={styles.letter}>A</p>
      <p className={styles.letter}>B</p>
      <p className={styles.letter}>C</p>
      <p className={styles.letter}>D</p>
      <p className={styles.letter}>E</p>
      <p className={styles.letter}>F</p>
      <p className={styles.letter}>G</p>
      <p className={styles.letter}>H</p>
      <p className={styles.letter}>I</p>
      <p className={styles.letter}>J</p>
      <p className={styles.letter}>K</p>
      <p className={styles.letter}>L</p>
      <p className={styles.letter}>M</p>
      <p className={styles.letter}>N</p>
      <p className={styles.letter}>O</p>
      <p className={styles.letter}>P</p>
      <p className={styles.letter}>Q</p>
      <p className={styles.letter}>R</p>
      <p className={styles.letter}>S</p>
      <p className={styles.letter}>T</p>
      <p className={styles.letter}>U</p>
      <p className={styles.letter}>V</p>
      <p className={styles.letter}>W</p>
      <p className={styles.letter}>Y</p>
      <p className={styles.letter}>Z</p>
    </div>
  );
};

export default Letter;
