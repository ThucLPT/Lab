import flask
import json

app = flask.Flask(__name__)
f = json.loads(open('music_info.json', encoding='utf-8').read())


@app.route('/')
def music():
    return flask.render_template('music.html', songs=f)


@app.route('/song/<ID>')
def song(ID):
    return flask.render_template('song.html', songs=f, Id=ID)


if __name__ == '__main__':
    app.run(debug=True)