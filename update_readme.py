import os
import re

# --- Configuration ---
README_FILE = 'README.md'
START_MARKER = ''
END_MARKER = ''
TOTAL_PROBLEMS_PER_SHEET = 26
SHEET_COUNT = 10 
# --- Emojis ---
DONE_EMOJI = '✅ Done'
IN_PROGRESS_EMOJI = '⏳ In Progress'
TO_DO_EMOJI = '❌ To Do'
STARTING_EMOJI = '🟢 Starting'


def generate_progress_table(solved_counts):
    """Generates the Markdown table content."""
    
    total_solved = 0
    table_rows = []
    
    for i in range(1, SHEET_COUNT + 1):
        sheet_folder = f'Sheet_{i:02d}'
        solved = solved_counts.get(sheet_folder, 0)
        total_solved += solved
        
        # Determine status emoji
        if solved == TOTAL_PROBLEMS_PER_SHEET:
            status = DONE_EMOJI
        elif solved > 0:
            status = IN_PROGRESS_EMOJI
        else:
            status = TO_DO_EMOJI
            
        # Build the row
        row = f"| **{sheet_folder.replace('_', ' ')}** | {TOTAL_PROBLEMS_PER_SHEET} | {solved} | {status} |"
        table_rows.append(row)

    # Calculate Total Row
    total_problems = SHEET_COUNT * TOTAL_PROBLEMS_PER_SHEET
    total_row = f"| **TOTAL** | **{total_problems}** | **{total_solved}** | |"
    table_rows.append(total_row)

    # Assemble the table content
    table_header = (
        "| Sheet | Total Problems | Solved | Status |\n"
        "| :---: | :---: | :---: | :--- |\n"
    )
    
    return table_header + '\n'.join(table_rows)


def get_solved_counts():
    """Scans the repository for solutions in sheet folders."""
    solved_counts = {}
    
    # Iterate through Sheet folders (e.g., Sheet_01, Sheet_02)
    for i in range(1, SHEET_COUNT + 1):
        sheet_folder = f'Sheet_{i:02d}'
        sheet_path = os.path.join(os.getcwd(), sheet_folder)
        
        solved = 0
        if os.path.isdir(sheet_path):
            # Recursively walk through the sheet folder
            for root, dirs, files in os.walk(sheet_path):
                for file in files:
                    if file.endswith('.java'):
                        solved += 1
        
        solved_counts[sheet_folder] = solved
        
    return solved_counts


def update_readme():
    """Reads, updates, and writes the README file."""
    try:
        with open(README_FILE, 'r', encoding='utf-8') as f:
            content = f.read()
    except FileNotFoundError:
        print(f"Error: {README_FILE} not found.")
        return

    solved_counts = get_solved_counts()
    new_table_content = generate_progress_table(solved_counts)

    # Find the content between the markers
    start_index = content.find(START_MARKER)
    end_index = content.find(END_MARKER)

    if start_index == -1 or end_index == -1:
        print("Error: README markers not found.")
        return

    # Extract the original content before and after the table
    before_table = content[:start_index + len(START_MARKER)]
    after_table = content[end_index:]

    # Construct the full new README content
    new_content = (
        before_table + '\n' +
        '\n' +
        '\n\n' +
        new_table_content + '\n\n' +
        after_table
    )

    # Write the new content back to the README
    with open(README_FILE, 'w', encoding='utf-8') as f:
        f.write(new_content)
    
    print(f"Successfully updated {README_FILE} with solution counts.")

if __name__ == '__main__':
    update_readme()