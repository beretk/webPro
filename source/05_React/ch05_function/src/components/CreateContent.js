const CreateContent = props => {
    return(
        <article>
            <h2>
                <form onSubmit={event => {
                                event.preventDefault();
                                props.onCreate(event.target.title.value, event.target.desc.value);
                }}>
                    <p><input type="text" name="title" placeholder="title" /></p>
                    <p><textarea name="desc" placeholder="desc"></textarea></p>
                    <p><input type="submit" value="추가"/></p>
                </form>
            </h2>
        </article>
    );
};
export default CreateContent;