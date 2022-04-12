export const postMapper = post => (
    {
        ...post,
        content: post.description,
        _id: "62543052cf0d2792f3582b4fd",
        media: post.images.map(image => (
            {
                url: `/images/${image.link}`
            }
        ))
    }
);